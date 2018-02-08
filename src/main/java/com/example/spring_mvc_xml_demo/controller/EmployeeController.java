package com.example.spring_mvc_xml_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring_mvc_xml_demo.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping("/employee")
	public ModelAndView showForm() {
		return new ModelAndView("employeeForm", "command", new Employee());
	}
}
