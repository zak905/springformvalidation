package com.opencode.controller;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;















import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opencode.model.Person;
import com.opencode.model.PersonValidator;

@Controller
public class FormController {
	
	@Autowired
	PersonValidator personValidator;
	
	 @InitBinder
	    private void initBinder(WebDataBinder binder) {
	        binder.setValidator(personValidator);
	    }
	 
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String displayForm(Map<String, Object> model){
		Person person = new Person();
		model.put("person", person);
		return "index";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String submitForm(@Validated @ModelAttribute("person") Person person,
            BindingResult result, Map<String, Object> model){
		
		if(result.hasErrors()){
			return "index";
		}
		return "add";
	}

}
