package com.seal.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.seal.daoobj.UserObj;
import com.seal.mapper.RoleMapper;
import com.seal.mapper.UserMapper;

@Service
public class SealUserDetailsService implements UserDetailsService {

	private static Logger logger = Logger.getLogger(SealUserDetailsService.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("username:" + username);
		UserObj userObj = userMapper.selectUserByName(username);
		Set<GrantedAuthority> authorities = new HashSet<>();
		if (userObj != null) {
			List<String> roles = roleMapper.selectRolebyUserId(userObj.getId());
			
			for (String role : roles) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				authorities.add(authority);
			}
		}
		
		UserDetails userDetails = new User(username, userObj.getPassword(), authorities);
		
		return userDetails;
	}

}
