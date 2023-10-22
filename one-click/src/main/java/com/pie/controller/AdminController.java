package com.pie.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.pie.model.Competetion;
import com.pie.service.GetCompetetion;
import com.pie.service.Parse2;
import com.pie.service.EntityWrapper;
import com.pie.service.ParseService;
import com.pie.service.SecurityServiceImpl;
import com.pie.service.CompetetionServices;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	CompetetionServices sc;

	@Autowired
	ParseService parser;
	
	@Autowired
	Parse2 parse2;

	@Autowired
	GetCompetetion getcomp;

	@Autowired
	SecurityServiceImpl logger;
	

	@GetMapping("/viewcompetetions")
	public String viewCompetetions(Model model)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		model.addAttribute("competetionlist", sc.getCompetetionList());
		return "viewcompetetions";

	}

	@GetMapping("/oneclick")
	public String oneclickpage(Model model) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		model.addAttribute("competetionlist", sc.getCompetetionList());
		return "oneclick";

	}

	@RequestMapping("/parse{id}")
	public String parsecompetetion(@PathVariable("id") int id, Model model)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		parse2.parse(sc.getCompetetionbyId(id),logger.findLoggedInUsername());
		return "redirect:/admin/oneclick";
	}

	@GetMapping("/addcompetetion")
	public String addCompetetion(Model model) {
		model.addAttribute("competetion", new Competetion());
		return "addcompetetion";
	}

	@RequestMapping(value = "/edit{id}")
	public String editcompetetion(@PathVariable("id") int id, Model model) {

		EntityWrapper entityWrapper = new EntityWrapper();
		entityWrapper.setEntityList(sc.getcompetetionentity(id));
		System.out.println(sc.getcompetetionentity(id));
		model.addAttribute("entityWrapper", entityWrapper);
		model.addAttribute("competetion", sc.getCompetetionbyId(id));
		return "edit";
	}
	
	
	@PostMapping(value="/success")
	public String editSuccess(@ModelAttribute("competetion") Competetion comp,@ModelAttribute("entityWrapper") EntityWrapper entityWrapper) {
		//
		System.out.println(comp);
		System.out.println(entityWrapper.getEntityList());
      	sc.editCompetetion(entityWrapper);
		
		return null;
		
	}

	@RequestMapping(value = "/delete{id}")
	public String deletecompetetion(@PathVariable("id") int id) {
		sc.deleteCompetetion(id);
		return "redirect:/admin/viewcompetetions";
	}
	
	
	

	@PostMapping("/competetiondetails")
	public String addcompdetails(@Valid @ModelAttribute("competetion") Competetion comp, BindingResult theBindingResult,Model model) {
	
		if(theBindingResult.hasErrors()) {
			System.out.println("in if");
			return "addcompetetion";
		} else {
			getcomp.setComp(comp);
			System.out.println("in else");
			EntityWrapper entityWrapper = sc.createwrapper(comp.getNumberfields());
			model.addAttribute("url", comp.getUrl());
			model.addAttribute("entityWrapper", entityWrapper);
			return "compdetails";
		}
	}

	@PostMapping("/addedsuccessful")
	public String addedcompEntities(@ModelAttribute("competetione") EntityWrapper entityWrapper) {
		sc.addCompetetionAndEntities(getcomp.getComp(), entityWrapper);
		return "competetionadded";

	}

}
