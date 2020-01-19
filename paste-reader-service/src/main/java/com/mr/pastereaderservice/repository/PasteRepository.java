package com.mr.pastereaderservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.mr.pastereaderservice.model.Paste;

@Repository
public class PasteRepository {
	
	@Autowired
	private DynamoDBMapper mapper;
	
	public Paste getPasteByUrl(String url) {
		Paste paste = mapper.load(Paste.class, url);
		return paste;
	}

}
