package com.example.spring_mvc_xml_demo.dao;

import java.util.List;

import com.example.spring_mvc_xml_demo.model.Contact;

public interface ContactDAO {
	public void saveOrUpdate(Contact contact);
    
    public void delete(int contactId);
     
    public Contact get(int contactId);
     
    public List<Contact> list();
}
