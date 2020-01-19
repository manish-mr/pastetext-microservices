package com.mr.pastewriterservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mr.pastewriterservice.exception.PasteWriterServiceException;
import com.mr.pastewriterservice.model.Paste;
import com.mr.pastewriterservice.service.PasteWriterService;

@RestController
public class PasteWriterController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PasteWriterService pasteWriterService;
	
	@PostMapping(path = "/writePaste")
	public String writePaste(@RequestBody Paste paste) {
		String tinyUrl = null;
		try {
			tinyUrl = pasteWriterService.writePaste(paste);
		} catch (PasteWriterServiceException e) {
			logger.error(e.getMessage());
			throw e;
		}
		return tinyUrl;
	}

}
