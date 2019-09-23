package com.seal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.seal.daoobj.UserObj;

@Mapper
@CacheConfig(cacheNames= {"users"})
public interface UserMapper {
	
	@Cacheable
	@Select("SELECT * FROM user WHERE username=#{username}")
	public UserObj selectUserByName(String username);
}
