package com.pie.service;



import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
@Configurable
@Service
public class SelectService{
	
	
   public int getIndex(Object mapping,String code) {
	   System.out.println("in select service index");
	   code = select(mapping, code);
	   System.out.println(code);
	   System.out.println(executor(code));
	    return executor(code);
	   
   }
    
    

    private String select(Object mapping,String code) {
    	String toReplace = null;
    	if(mapping instanceof Integer) {
    		int x = (int) mapping;
    		 toReplace = String.valueOf(x);
    	}
    	else if(mapping instanceof String) {
    		toReplace = (String)mapping;
    	}
    	code = code.replaceFirst("xyz", toReplace);
		return code;
    	
    }
    
    private int executor(String code) {
    	
    	Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        Object value = shell.evaluate(code);
		return (int)value;
    
    }
    
}