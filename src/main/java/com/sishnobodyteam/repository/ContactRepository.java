package com.sishnobodyteam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sishnobodyteam.entity.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
