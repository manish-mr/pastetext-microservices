package com.mr.pastewriterservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.mr.pastewriterservice.model.Paste;

@Repository
public class PasteRepository {
	
	@Autowired
	private DynamoDBMapper mapper;
	
	public void insert(Paste paste) {
		mapper.save(paste);
	}

}
