package com.mr.pastereaderservice.exception;

/**
 * {@link PasteNotFoundException} is the subclass of {@link PasteReaderServiceException}, it should
 * be raised when there is no corresponding paste in the database for the requested tiny URL
 * @author Manish
 *
 */
public class PasteNotFoundException extends PasteReaderServiceException {

	private static final long serialVersionUID = -4174052977433021381L;
	
	public PasteNotFoundException() {
		
	}
	
	public PasteNotFoundException(String message) {
		super(message);
	}
	
	public PasteNotFoundException(Throwable th) {
		super(th);
	}

}
