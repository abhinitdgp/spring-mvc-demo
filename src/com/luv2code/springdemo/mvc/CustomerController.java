package com.luv2code.springdemo.mvc;

import javax.validation.Valid;
import javax.xml.bind.Binder;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// add an initbinder.. to convert trim input strings
	// remove leading and trailing white spaces
	// resolve issue for our validation

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// true to trim it to null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult) {
		System.out.println("Last name: |" + theCustomer.getLastName());

		System.out.println("Binding Result: " + bindingResult);

		if (bindingResult.hasErrors()) {
			return "customer-form";
		} else
			return "customer-confirmation";
	}

}
