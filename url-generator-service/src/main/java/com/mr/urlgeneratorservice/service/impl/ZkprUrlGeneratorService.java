package com.mr.urlgeneratorservice.service.impl;

import org.springframework.stereotype.Service;

import com.mr.urlgeneratorservice.service.UrlGeneratorService;

/**
 * An implementation of {@link UrlGeneratorService}. This implementation uses
 * Zookeeper to generate URLs.
 * @author manish
 *
 */
@Service
public class ZkprUrlGeneratorService implements UrlGeneratorService{
	
	public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final int BASE = ALPHABET.length();
	
	public static final int URL_SIZE = 7;
	
	private int counter = 100000;
	
	@Override
	public String generateTinyUrl() {
		String tinyUrl = base62(counter);
		counter ++;
		return tinyUrl;
	}
	
	/**
	 * Base 62 conversion for the given number.
	 * @param num
	 * @return
	 */
	private String base62(long num) {
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
	
//	public static void main(String[] args) {
//		ZkprUrlGeneratorService service = new ZkprUrlGeneratorService();
//		System.out.println(service.base62(62));
//		System.out.println(service.base62(63));
//		System.out.println(service.base62(64));
//		System.out.println(service.base62(72));
//		System.out.println(service.base62(73));
//		
//		System.out.println(service.base62(1000000000000L));
//		System.out.println(service.base62(3500000000000L));
//		System.out.println(service.base62(10000));
//		System.out.println(service.base62(225444));
//	}

}
