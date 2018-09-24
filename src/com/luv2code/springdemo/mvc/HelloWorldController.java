package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	// need a controller method to show the initial HTML from
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller method to process HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// add a new controller method to read form data
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// read the request parameter from HTML form
		String name = request.getParameter("studentName");

		// convert the data to all CAPS
		name = name.toUpperCase();

		// create the message
		String result = "Yo! " + name;

		// add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName")String theName, Model model) {
		// read the request parameter from HTML form
		//String name = request.getParameter("studentName");

		// convert the data to all CAPS
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey Friend: " + theName;

		// add message to the model
		model.addAttribute("message", result);
		return "helloworld";
	}

}
