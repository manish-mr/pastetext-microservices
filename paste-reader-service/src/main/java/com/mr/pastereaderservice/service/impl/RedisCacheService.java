package com.mr.pastereaderservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.pastereaderservice.model.Paste;
import com.mr.pastereaderservice.service.CacheService;

import redis.clients.jedis.Jedis;

/**
 * {@link CacheService} implementation for Redis
 * @author Manish
 *
 */
@Service
public class RedisCacheService implements CacheService{
	
	@Autowired
	private Jedis jedis;


	@Override
	public boolean exists(String url) {
		return jedis.exists(url);
	}

	@Override
	public void set(Paste paste) {
		// TODO Auto-generated method stub
		jedis.set(paste.getUrl(), paste.getContent());
		
	}

	@Override
	public Paste get(String url) {
		String content = jedis.get(url);
		return new Paste(url, content);
	}
	
//	public static void main(String[] args) {
//		RedisCacheService redisCacheService = new RedisCacheService();
//		String url = "hhjjkk";
//		Paste paste = new Paste(url, "Testing content!!!");
//		redisCacheService.set(paste);
//		
//		if(redisCacheService.exists(url)) {
//			Paste ps = redisCacheService.get(url);
//			System.out.println("Exists");
//			System.out.println(ps.getContent());
//		} else {
//			System.out.println("Does not exists");
//		}
//		
//	}

}
