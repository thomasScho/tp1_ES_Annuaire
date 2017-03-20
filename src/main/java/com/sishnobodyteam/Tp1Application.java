package com.sishnobodyteam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.sishnobodyteam.entity.Contact;
import com.sishnobodyteam.entity.ContactES;
import com.sishnobodyteam.entity.KeyWord;
import com.sishnobodyteam.repository.elasticsearch.ContactRepositoryES;
import com.sishnobodyteam.repository.mongodb.ContactRepository;
import com.sishnobodyteam.repository.mongodb.KeyWordRepository;

@SpringBootApplication
public class Tp1Application implements CommandLineRunner {

	@Autowired
	private ContactRepositoryES contactRepositoryES;

	@Autowired
	private KeyWordRepository keyWordRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void run(String... args) throws Exception {

		this.contactRepositoryES.deleteAll();

		KeyWord keyWord = new KeyWord();
		keyWord.setLabel("restaurant");
		keyWord = keyWordRepository.save(keyWord);

		List<KeyWord> keyWords = new ArrayList<>();
		keyWords.add(keyWord);

		Contact contact = new Contact();
		contact.setKeyWords(keyWords);
		contact.setLocation(new GeoJsonPoint(5, 5));
		contact.setUsername("kebab Cergy");
		contactRepository.save(contact);

		syncDatabseElasticSearch();
	}
	
	public void syncDatabseElasticSearch() {
		List<Contact> datasMongoDB = contactRepository.findAll();
		for (Contact c : datasMongoDB) {
			contactRepositoryES.save(new ContactES(c));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);
	}
}
