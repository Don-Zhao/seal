package com.seal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
@EnableCaching
public class SealApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SealApplication.class, args);
		
		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
	
//	@Bean
//	public CacheManager cacheManager() {
//		SimpleCacheManager manager = new SimpleCacheManager();
//		return manager;
//	}
	
//	@Bean
//	public StringRedisTemplate redisTemplate() {
//		return new StringRedisTemplate();
//	}

}
