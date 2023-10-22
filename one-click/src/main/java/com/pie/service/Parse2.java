package com.pie.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlCheckBoxInput;
import com.gargoylesoftware.htmlunit.html.HtmlEmailInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlNumberInput;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlRadioButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.pie.dao.CompetetionFieldRepository;
import com.pie.dao.CompetetionRepository;
import com.pie.dao.UserRepository;
import com.pie.model.Competetion;
import com.pie.model.CompetetionEntity;
import com.pie.model.User;

@Configurable
@Service
public class Parse2 {

	@Autowired
	private CompetetionRepository icomp;

	@Autowired
	private CompetetionFieldRepository ientity;

	@Autowired
	UserRepository iuser;

	@Autowired
	SelectService selector;

	public String getUsermapping(User user, CompetetionEntity ce) {
		if (ce.getUserData().equals("FirstName"))
			return user.getFirstname();
		else if (ce.getUserData().equals("LastName"))
			return user.getLastname();
		else if (ce.getUserData().equals("Email"))
			return user.getEmail();
		else if (ce.getUserData().equals("Phone No."))
			return user.getPhn();
		else if (ce.getUserData().equals("Address"))
			return user.getAddress();
		else if (ce.getUserData().equals("Postcode"))
			return user.getPostcode();
		else if (ce.getUserData().equals("City"))
			return user.getCity();
		else if (ce.getUserData().equals("Suburb"))
			return user.getSuburb();
		else if (ce.getUserData().equals("Country"))
			return user.getCountry();
		else if (ce.getUserData().equals("Password"))
			return user.getPassword();
		return null;
	}
	

	private WebClient getWebClient() {
		WebClient webClient = new WebClient();
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		return webClient;
	}

	public void parse(Competetion comp,String email)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {

		
		
		
		User user = iuser.findByEmail(email);
		WebClient webClient = getWebClient();
		
		
       
        
        System.out.println(comp);
        //	try {	
		HtmlPage Page = webClient.getPage(comp.getUrl());
		List<HtmlForm> forms = Page.getForms();
		HtmlForm form = forms.get(comp.getFormno());

		List<CompetetionEntity> ls = ientity.findByCompetetionid(comp.getId());
		HtmlPage page = null;
		//competetionfields
		for (CompetetionEntity ce : ls) {
			System.out.println(ce);
			String type = ce.getFieldtype();
			System.out.println(type);

			if (type.equals("TextInput") || type.equals("EmailInput") || type.equals("NumberInput")
					|| type.equals("PasswordInput")) {

				if (!ce.getFieldname().equals("")) {
					form.getInputByName(ce.getFieldname()).setValue(getUsermapping(user, ce));
				}

			} else if (ce.getFieldtype().equals("TextInput")) {
				HtmlTextInput element = form.getOneHtmlElementByAttribute("input", "id", ce.getFieldid());
				element.setValue(getUsermapping(user, ce));

			} else if (ce.getFieldtype().equals("EmailInput")) {
				HtmlEmailInput element = form.getOneHtmlElementByAttribute("input", "id", ce.getFieldid());
				element.setValue(getUsermapping(user, ce));

			} else if (ce.getFieldtype().equals("NumberInput")) {
				HtmlNumberInput element = form.getOneHtmlElementByAttribute("input", "id", ce.getFieldid());
				element.setValue(getUsermapping(user, ce));

			} else if (ce.getFieldtype().equals("PasswordInput")) {
				HtmlPasswordInput element = form.getOneHtmlElementByAttribute("input", "id", ce.getFieldid());
				element.setValue(getUsermapping(user, ce));

			} else if (ce.getFieldtype().equals("SubmitInput")) {
				HtmlSubmitInput submit;
				System.out.println("in submit");
				if (!ce.getFieldname().equals("")) {
					System.out.println(ce.getFieldname());
					System.out.println("finding by name");
					submit = form.getInputByName(ce.getFieldname());
					System.out.println(submit);
				} else {
					System.out.println("finding by id");
					submit = form.getOneHtmlElementByAttribute("input", "id", ce.getFieldid());
				}
				System.out.println("after finding submit");
				page = submit.click();

			} else if (ce.getFieldtype().equals("Button")) {

				if (ce.getFieldname() != null) {
					page = form.getButtonByName(ce.getFieldname()).click();
				} else {

					HtmlButton button = form.getOneHtmlElementByAttribute("button", "id", ce.getFieldid());
					page = button.click();
				}

			} else if (ce.getFieldtype().equals("TextArea")) {
				if (ce.getFieldname() != null) {
					form.getTextAreaByName(ce.getFieldname()).setText(getUsermapping(user, ce));
				} else {
					HtmlTextArea element = form.getOneHtmlElementByAttribute("textarea", "id", ce.getFieldid());
					element.setText(getUsermapping(user, ce));
				}

			} else if (ce.getFieldtype().equals("CheckBox")) {
				if (ce.getFieldname() != null) {
					form.getInputByName(ce.getFieldname()).setChecked(true);
				} else {
					HtmlCheckBoxInput checkbox = form.getOneHtmlElementByAttribute("input", "id", ce.getFieldid());
					checkbox.setChecked(true);
				}
			} else if (ce.getFieldtype().equals("Select")) {
				HtmlSelect select;
				if (ce.getFieldname() != null) {
					select = form.getSelectByName(ce.getFieldname());
				} else {
					select = form.getOneHtmlElementByAttribute("select", "id", ce.getFieldid());
				}
				HtmlOption option = select.getOption(selector.getIndex(getUsermapping(user, ce), ce.getCode()));
				select.setSelectedAttribute(option, true);
			}

			else if (ce.getFieldtype().equals("RadioButton")) {
				if (ce.getFieldname() != null) {
					HtmlRadioButtonInput radio = form.getCheckedRadioButton(ce.getFieldname());
					radio.click();
				} else {
					HtmlRadioButtonInput radio = form.getOneHtmlElementByAttribute("input", "id", ce.getFieldid());
					radio.click();
				}
			}
			else {
				System.out.println("error while parsing");
			}

		}
        System.out.println(page.getBaseURL());
        System.out.println(comp.getFinalurl());
		if(page.getBaseURL().equals(comp.getFinalurl())) {
			System.out.println("mark enter");
				
		}
//	}
//        	
//        	catch(Exception e) {
//    			System.out.println("Exception occured while filling a competetion");
//    		}
        
	
		
		
	}

}
