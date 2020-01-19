package com.mr.urlgeneratorservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mr.urlgeneratorservice.exception.UrlGeneratorServiceException;
import com.mr.urlgeneratorservice.service.UrlGeneratorService;

/**
 * An implementation of {@link UrlGeneratorService}.
 * @author manish
 *
 */
@Service
public class UrlGeneratorServiceImpl implements UrlGeneratorService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final int BASE = ALPHABET.length();
	
	public static final int URL_SIZE = 7;
	
	private int counter = 100000;
	
	@Override
	public String generateTinyUrl() {
		String tinyUrl = null;
		try {
			tinyUrl = base62(counter);
			counter ++;
		} catch(Exception e) {
			logger.error(e.getMessage());
			throw new UrlGeneratorServiceException(e);
		}
		return tinyUrl;
	}
	
	/**
	 * Base 62 conversion for the given number.
	 * @param num
	 * @return
	 */
	public String base62(long num) {
		StringBuilder result = new StringBuilder();
		
		int rem = (int) (num % BASE);
		result.append(ALPHABET.charAt(rem));
		long quo = Math.floorDiv(num, BASE);
		while(quo > 0) {
			rem = (int) (quo % BASE);
			quo = Math.floorDiv(quo, BASE);
			result.insert(0, ALPHABET.charAt(rem));
		}
		// Adding the leading zeros
		while(result.length() < URL_SIZE) {
			result.insert(0, '0');
		}
		return result.toString();
	}

}
