package com.sishnobodyteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sishnobodyteam.dto.CreateContactDTO;
import com.sishnobodyteam.entity.Contact;
import com.sishnobodyteam.entity.KeyWord;
import com.sishnobodyteam.repository.mongodb.ContactRepository;
import com.sishnobodyteam.repository.mongodb.KeyWordRepository;

@Controller
public class AjoutController {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private KeyWordRepository keyWordRepository;

	@GetMapping("/contact")
	public ModelAndView displayAjoutContactPage() {
		return new ModelAndView("ajoutContact", "object",
				new CreateContactDTO(keyWordRepository.findAll()));
	}

	@PostMapping("/contact")
	public ModelAndView postAddContact(@ModelAttribute Contact contact) {
		List<KeyWord> keyWords = keyWordRepository.findAll();
		contact.setKeyWords(keyWords);
		contactRepository.save(contact);

		return new ModelAndView("redirect:/");
	}

	@GetMapping("/motcle")
	public ModelAndView displayAjoutMotClePage() {
		return new ModelAndView("ajoutMotCle", "keyword", new KeyWord());
	}

	@PostMapping("/motcle")
	public ModelAndView postAddKeyWord(@ModelAttribute KeyWord keyword) {
		keyWordRepository.save(keyword);
		return new ModelAndView("redirect:/");
	}
}
