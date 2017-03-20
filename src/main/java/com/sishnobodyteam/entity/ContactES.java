package com.sishnobodyteam.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "contact", type = "post", shards = 1, replicas = 0)
public class ContactES {
	@Id
	private String id;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public ContactES(Contact contact) {
		this.username = contact.getUsername();
		this.id = "1";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ContactES(String id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	public ContactES() {

	}
}
