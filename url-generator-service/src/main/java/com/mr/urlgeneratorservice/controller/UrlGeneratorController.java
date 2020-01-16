package com.mr.urlgeneratorservice.controller;

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
	
	@Autowired
	private UrlGeneratorService urlGeneratorService;
	
	@GetMapping(path = "/generateUrl")
	public String generateTinyUrl() {
		String tinyUrl = urlGeneratorService.generateTinyUrl();
		return tinyUrl;
	}

}
