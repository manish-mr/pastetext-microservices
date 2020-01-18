package com.mr.pastewriterservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "url-generator-service")
public interface UrlGeneratorServiceProxy {
	
	@GetMapping("/generateUrl")
	public String generateUrl();

}
