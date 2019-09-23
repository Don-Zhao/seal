package com.seal.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {
//	@Bean
//	public JedisPoolConfig jedisPoolConfig() {
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		
//		return jedisPoolConfig;
//		
//	}
//	
//	@Bean
//	public JedisPool jedisPool() {
//		JedisPool jedisPool = new JedisPool(this.jedisPoolConfig(), "localhost", 6379);
//		return jedisPool;
//	}
//	
//	@Bean
//	public RedisConnectionFactory redisConnectionFactory() {
//		return new JedisConnectionFactory(this.jedisPoolConfig());
//	}
//
//	@Bean
//	public StringRedisTemplate stringRedisTemplate() {
//		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(this.redisConnectionFactory());
//		return stringRedisTemplate;
//	}
//	
//	@Bean(name="cacheManager")
//	public CacheManager cacheManager() {
//		RedisCacheManager cacheManager = RedisCacheManager.create(this.redisConnectionFactory());
//		return cacheManager;
//	}
//	
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate() {
//		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
//		redisTemplate.setConnectionFactory(this.redisConnectionFactory());
//		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//		
//		ObjectMapper om = new ObjectMapper();
//		om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
//		om.enableDefaultTyping(DefaultTyping.NON_FINAL);
//		jackson2JsonRedisSerializer.setObjectMapper(om);
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//		redisTemplate.afterPropertiesSet();
//		return redisTemplate;
//	}
//	
//	@Bean
//	public KeyGenerator wiselyKeyGenerator() {
//		return new KeyGenerator() {
//
//			@Override
//			public Object generate(Object target, Method method, Object... params) {
//				StringBuffer sb = new StringBuffer();
//				sb.append("mykey:");
//				sb.append(method.getName() + ":");
//				for (Object object : params) {
//					sb.append(object.toString());
//				}
//				return sb.toString();
//			}
//
//		};
//		
//	}
}
