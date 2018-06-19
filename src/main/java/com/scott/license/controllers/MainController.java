package com.scott.license.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scott.license.models.License;
import com.scott.license.models.Person;
import com.scott.license.services.MainService;

@Controller
public class MainController {
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/person.jsp";
	}
	
	@PostMapping("/person/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/person.jsp";
		}else {
			mainService.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("persons", mainService.allPeople());
		return "/license.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "/license.jsp";
		}else {
			System.out.println(license.getPerson().getFirstName());
			System.out.println(license);
//			mainService.getPerson(license.person);
			mainService.createLicense(license);
			
			
			return "/license.jsp";
		}
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping("/persons/{id}")
	public String findPersons(@PathVariable("id") Long id, Model model) {
		if(mainService.getPerson(id) == null) {
			return "redirect:/persons/new";
		}else {
			Person p = mainService.getPerson(id);
			model.addAttribute("person", p);
			return "/profile.jsp";
		}
	}
	
}





