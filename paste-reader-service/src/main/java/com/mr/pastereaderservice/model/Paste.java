package com.mr.pastereaderservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Paste object which stores specifications and characteristics of a paste.
 * @author manish
 *
 */
@DynamoDBTable(tableName = "pastes")
public class Paste {
	
	@DynamoDBHashKey
	private String url;
	
	@DynamoDBAttribute
	private String content;
	
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
