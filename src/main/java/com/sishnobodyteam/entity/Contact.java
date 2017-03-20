package com.sishnobodyteam.entity;

import java.util.List;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public class Contact {
	private String username;
	private GeoJsonPoint location;
	private List<KeyWord> keyWords;

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

	public List<KeyWord> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(List<KeyWord> keyWords) {
		this.keyWords = keyWords;
	}

}
