package com.mr.pastereaderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mr.pastereaderservice.model.Paste;
import com.mr.pastereaderservice.service.PasteReaderService;

@RestController
public class PasteReaderController {
	
	@Autowired
	private PasteReaderService pasteReaderService;
	
	@GetMapping("/readPaste/{url}")
	public Paste getPaste(@PathVariable String url) {
		System.out.println("---->>" + url);
		Paste paste = pasteReaderService.getPaste(url);
		return paste;
	}

}
