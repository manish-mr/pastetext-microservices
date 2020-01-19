package com.mr.pastereaderservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.pastereaderservice.model.Paste;
import com.mr.pastereaderservice.repository.PasteRepository;
import com.mr.pastereaderservice.service.CacheService;
import com.mr.pastereaderservice.service.PasteReaderService;

@Service
public class PasteReaderServiceImpl implements PasteReaderService{

	@Autowired
	private PasteRepository pasteRepository;
	
	@Autowired
	private CacheService cacheService;
	
	@Override
	public Paste getPaste(String url) {
		Paste paste = null;
		if(cacheService.exists(url)) {
			System.out.println("paste found for ----->>> " + url);
			paste = cacheService.get(url);
		} else {
			paste = pasteRepository.getPasteByUrl(url);
			cacheService.set(paste);
			System.out.println("paste NOT found so adding paste for ----->>> " + url);
		}
		return paste;
	}
	
}
