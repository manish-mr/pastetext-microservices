package com.mr.pastewriterservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.pastewriterservice.model.Paste;
import com.mr.pastewriterservice.proxy.UrlGeneratorServiceProxy;
import com.mr.pastewriterservice.repository.PasteRepository;
import com.mr.pastewriterservice.service.PasteWriterService;

/**
 * Implementation of {@link PasteWriterService}, it uses URL Generator microservice to 
 * generate the tiny url for the paste and then stores the paste into Amazon Dynamo DB
 * @author Manish
 *
 */
@Service
public class PasteWriterServiceImpl implements PasteWriterService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PasteRepository pasteRepository;
	
	@Autowired
	private UrlGeneratorServiceProxy urlGeneratorServiceProxy;

	@Override
	public String writePaste(Paste paste) {
		// mocked
		//String tinyUrl = "jhsd772";
		String tinyUrl = urlGeneratorServiceProxy.generateUrl();
		logger.info("TinyURL recieved: " + tinyUrl);
		paste.setUrl(tinyUrl);
		
		// Store in database
		pasteRepository.insert(paste);
		logger.info("Paste stored in database");
		
		return tinyUrl;
	}

}
