package com.mr.pastewriterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.mr.pastewriterservice.proxy")
public class PasteWriterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasteWriterServiceApplication.class, args);
	}

}
