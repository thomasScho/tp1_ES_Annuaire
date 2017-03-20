package com.sishnobodyteam.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sishnobodyteam.entity.KeyWord;

public interface KeyWordRepository extends MongoRepository<KeyWord, String> {

}
