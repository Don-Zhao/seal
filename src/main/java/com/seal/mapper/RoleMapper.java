package com.seal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {
	
	@Select("SELECT role FROM role WHERE user_id=#{id}")
	public List<String> selectRolebyUserId(int id);
}
