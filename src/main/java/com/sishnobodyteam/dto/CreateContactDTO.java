package com.sishnobodyteam.dto;

import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.sishnobodyteam.entity.Contact;
import com.sishnobodyteam.entity.KeyWord;

public class CreateContactDTO {
	private List<KeyWord> keyWords;
	private String username;
	private GeoJsonPoint location;
	
	public List<KeyWord> getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(List<KeyWord> keyWords) {
		this.keyWords = keyWords;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public GeoJsonPoint getLocation() {
		return location;
	}
	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}
	public CreateContactDTO(List<KeyWord> keyWords) {
		this.keyWords = keyWords;
	}

}
