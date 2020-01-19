package com.mr.urlgeneratorservice.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UrlGeneratorServiceImplTest {

	private UrlGeneratorServiceImpl service = new UrlGeneratorServiceImpl();
	
	@Test
	void testBase62() {
		assertEquals("0000000" , service.base62(0));
		assertEquals("0000001" , service.base62(1));
		assertEquals("00000g8" , service.base62(1000));
		assertEquals("0065D6U" , service.base62(90000000));
		assertEquals("006LAze" , service.base62(100000000));
	}

}
