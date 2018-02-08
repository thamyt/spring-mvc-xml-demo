package com.example.spring_mvc_xml_demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring_mvc_xml_demo.dao.ContactDAO;
import com.example.spring_mvc_xml_demo.model.Contact;

@Controller
public class ContactController {
	@Autowired
    private ContactDAO contactDAO;
	
	@RequestMapping(value="/listContact")
	public ModelAndView listContact(ModelAndView model) throws IOException{
	    List<Contact> listContact = contactDAO.list();
	    model.addObject("listContact", listContact);
	    model.setViewName("ContactHome");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
	    Contact newContact = new Contact();
	    model.addObject("contact", newContact);
	    model.setViewName("ContactForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@Valid @ModelAttribute Contact contact,
									BindingResult result) {
	    
		if (result.hasErrors()) {
			if ( contact.getId() == 0 ) {
				// new contact ???
				//return new ModelAndView("redirect:/newContact", contact);
				return new ModelAndView("ContactForm", new ModelMap("contact",contact));
			}
			else {
				// return new ModelAndView("redirect:/editContact?id=" + contact.getId());
				
				return new ModelAndView("ContactForm", new ModelMap("contact",contact));
			}
        }
		
		contactDAO.saveOrUpdate(contact);
	    return new ModelAndView("redirect:/listContact");
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    contactDAO.delete(contactId);
	    return new ModelAndView("redirect:/listContact");
	}
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    Contact contact = contactDAO.get(contactId);
	    ModelAndView model = new ModelAndView("ContactForm");
	    model.addObject("contact", contact);
	 
	    return model;
	}
	
}
