package com.mr.urlgeneratorservice.exception;

/**
 * {@link UrlGeneratorServiceException} can be raised in case of any underlying
 * exceptions in Url Generator Service. It is a parent exception class for any
 * specific underlying exceptions related to Url Generator Service.
 * @author Manish
 *
 */
public class UrlGeneratorServiceException extends RuntimeException {

	private static final long serialVersionUID = 1422380017588435269L;
	
	
	public UrlGeneratorServiceException() {
		
	}
	
	public UrlGeneratorServiceException(String message) {
		super(message);
	}
	
	public UrlGeneratorServiceException(Throwable th) {
		super(th);
	}

}

