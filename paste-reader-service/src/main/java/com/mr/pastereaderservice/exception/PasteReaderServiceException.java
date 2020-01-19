package com.mr.pastereaderservice.exception;

/**
 * {@link PasteReaderServiceException} can be raised in case of any underlying
 * exceptions in Paste Reader Service. It is a parent exception class for any
 * specific underlying exceptions related to Paste Reader Service.
 * @author Manish
 *
 */
public class PasteReaderServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 3771313715732853788L;

	public PasteReaderServiceException() {
		
	}
	
	public PasteReaderServiceException(String message) {
		super(message);
	}
	
	public PasteReaderServiceException(Throwable th) {
		super(th);
	}
	
}
