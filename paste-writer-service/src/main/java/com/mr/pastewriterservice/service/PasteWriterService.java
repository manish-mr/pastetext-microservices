package com.mr.pastewriterservice.service;

import com.mr.pastewriterservice.model.Paste;

/**
 * Paste writer service
 * @author Manish
 *
 */
public interface PasteWriterService {
	
	/**
	 * write paste into the storage
	 * @param paste
	 * @return
	 */
	String writePaste(Paste paste);
	
}
