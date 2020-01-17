package com.mr.pastewriterservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mr.pastewriterservice.model.Paste;
import com.mr.pastewriterservice.service.PasteWriterService;

@RestController
public class PasteWriterController {
	
	@Autowired
	private PasteWriterService pasteWriterService;
	
	@PostMapping(path = "/writePaste")
	public String writePaste(@RequestBody Paste paste) {
		System.out.println("---->>>" + paste.getContent());
		String tinyUrl = pasteWriterService.writePaste(paste);
		return tinyUrl;
	}

}
