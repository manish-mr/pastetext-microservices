package com.mr.pastereaderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mr.pastereaderservice.exception.PasteReaderServiceException;
import com.mr.pastereaderservice.model.Paste;
import com.mr.pastereaderservice.service.PasteReaderService;

@RestController
public class PasteReaderController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PasteReaderService pasteReaderService;
	
	@GetMapping("/readPaste/{url}")
	public Paste getPaste(@PathVariable String url) {
		Paste paste;
		try {
			logger.info("Read paste request recieved for URL: " + url);
			paste = pasteReaderService.getPaste(url);
		} catch (PasteReaderServiceException e) {
			logger.error(e.getMessage()); 
			throw e;
		}
		return paste;
	}

}
