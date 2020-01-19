package com.mr.pastewriterservice.exception;

/**
 * {@link PasteWriterServiceException} can be raised in case of any underlying
 * exceptions in Paste Writer Service. It is a parent exception class for any
 * specific underlying exceptions related to Paste Writer Service.
 * @author Manish
 *
 */
public class PasteWriterServiceException extends RuntimeException {

	private static final long serialVersionUID = -3966716010844117262L;

	public PasteWriterServiceException() {
		
	}
	
	public PasteWriterServiceException(String message) {
		super(message);
	}
	
	public PasteWriterServiceException(Throwable th) {
		super(th);
	}
}
