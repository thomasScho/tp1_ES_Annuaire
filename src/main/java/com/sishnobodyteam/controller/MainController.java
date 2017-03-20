package com.sishnobodyteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sishnobodyteam.entity.Contact;
import com.sishnobodyteam.repository.ContactRepository;

@Controller
public class MainController {

	@Autowired
	private ContactRepository contactRepository;

	@GetMapping("/")
	public ModelAndView displayMainPage() {
		List<Contact> contacts = contactRepository.findAll();
		System.out.println("Taille contacts : " + contacts.size());
		return new ModelAndView("index", "contacts", contacts);
	}
}
