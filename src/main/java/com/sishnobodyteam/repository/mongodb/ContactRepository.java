package com.sishnobodyteam.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sishnobodyteam.entity.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
