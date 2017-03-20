package com.sishnobodyteam.dto;

import java.util.List;

import com.sishnobodyteam.entity.Contact;
import com.sishnobodyteam.entity.KeyWord;

public class CreateContactDTO {
	private List<KeyWord> keyWords;
	private Contact contact;

	public List<KeyWord> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(List<KeyWord> keyWords) {
		this.keyWords = keyWords;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public CreateContactDTO(List<KeyWord> keyWords, Contact contact) {
		super();
		this.keyWords = keyWords;
		this.contact = contact;
	}

}
