package com.mr.urlgeneratorservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mr.urlgeneratorservice.service.UrlGeneratorService;

/**
 * Rest controller for URL generator.
 * @author manish
 *
 */
@RestController
public class UrlGeneratorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UrlGeneratorService urlGeneratorService;
	
	@GetMapping(path = "/generateUrl")
	public String generateTinyUrl() {
		logger.info("Request recieved");
		String tinyUrl = urlGeneratorService.generateTinyUrl();
		return tinyUrl;
	}

}
