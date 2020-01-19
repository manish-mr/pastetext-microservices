package com.mr.pastereaderservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.pastereaderservice.model.Paste;
import com.mr.pastereaderservice.repository.PasteRepository;
import com.mr.pastereaderservice.service.PasteReaderService;

@Service
public class PasteReaderServiceImpl implements PasteReaderService{

	@Autowired
	private PasteRepository pasteRepository;
	
	@Override
	public Paste getPaste(String url) {
		Paste paste = pasteRepository.getPasteByUrl(url);
		return paste;
	}
	
}
