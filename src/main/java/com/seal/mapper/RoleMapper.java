package com.seal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@Mapper
@CacheConfig(cacheNames= {"roles"})
public interface RoleMapper {
	
	@Cacheable
	@Select("SELECT role FROM role WHERE user_id=#{id}")
	public List<String> selectRolebyUserId(int id);
}
