package com.sishnobodyteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sishnobodyteam.entity.Contact;
import com.sishnobodyteam.repository.mongodb.ContactRepository;

@Controller
public class MainController {

	@Autowired
	private ContactRepository contactRepository;

	@GetMapping("/")
	public ModelAndView displayMainPage() {
		List<Contact> contacts = contactRepository.findAll();
		return new ModelAndView("index", "contacts", contacts);
	}
}
