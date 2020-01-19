package com.mr.pastereaderservice.service;

import com.mr.pastereaderservice.model.Paste;

/**
 * This service is responsible for all cache operations.
 */
public interface CacheService {
	
	boolean exists(String url);
	
	void set(Paste paste);
	
	Paste get(String url);
}
