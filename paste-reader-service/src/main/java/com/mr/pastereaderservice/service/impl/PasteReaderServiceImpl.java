package com.mr.pastereaderservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.pastereaderservice.exception.PasteNotFoundException;
import com.mr.pastereaderservice.exception.PasteReaderServiceException;
import com.mr.pastereaderservice.model.Paste;
import com.mr.pastereaderservice.repository.PasteRepository;
import com.mr.pastereaderservice.service.CacheService;
import com.mr.pastereaderservice.service.PasteReaderService;

@Service
public class PasteReaderServiceImpl implements PasteReaderService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PasteRepository pasteRepository;
	
	@Autowired
	private CacheService cacheService;
	
	@Override
	public Paste getPaste(String url) {
		Paste paste = null;
		try {
			logger.debug("Finding paste in cache for URL: " + url);
			if(cacheService.exists(url)) {
				logger.info("Paste found in cache for URL: " + url);
				paste = cacheService.get(url);
			} else {	// look out for paste in storage
				logger.info("Paste not found in cache for URL: " + url);
				paste = pasteRepository.getPasteByUrl(url);
				if(paste == null) {
					throw new PasteNotFoundException("Paste not found for URL: " + url);
				}
				cacheService.set(paste);
				logger.info("Storing paste in cache for URL: " + url);
			}
		} catch (PasteNotFoundException e) {
			logger.error(e.getMessage());
			throw new PasteNotFoundException(e);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new PasteReaderServiceException(e);
		}
		return paste;
	}
	
}
