package com.mr.pastereaderservice.service;

import com.mr.pastereaderservice.model.Paste;

public interface PasteReaderService {
	
	Paste getPaste(String url);

}
