package com.sishnobodyteam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.sishnobodyteam.entity.Contact;
import com.sishnobodyteam.entity.KeyWord;
import com.sishnobodyteam.repository.ContactRepository;
import com.sishnobodyteam.repository.KeyWordRepository;

@SpringBootApplication
public class Tp1Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private KeyWordRepository keyWordRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void run(String... args) throws Exception {

		this.repository.deleteAll();
		saveCustomers();
		fetchAllCustomers();
		fetchIndividualCustomers();

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

	}

	private void saveCustomers() {
		this.repository.save(new Customer("Alice", "Smith"));
		this.repository.save(new Customer("Bob", "Smith"));
	}

	private void fetchAllCustomers() {
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();
	}

	private void fetchIndividualCustomers() {
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);
	}
}
