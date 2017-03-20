package com.sishnobodyteam.repository.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sishnobodyteam.entity.Contact;
import com.sishnobodyteam.entity.ContactES;

public interface ContactRepositoryES extends ElasticsearchRepository<ContactES, String> {

}
