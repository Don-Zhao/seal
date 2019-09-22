package com.seal.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.seal.daoobj.UserObj;

@Mapper
@CacheNamespace
public interface UserMapper {
	
	@Select("SELECT * FROM user WHERE username=#{username}")
	public UserObj selectUserByName(String username);
}
