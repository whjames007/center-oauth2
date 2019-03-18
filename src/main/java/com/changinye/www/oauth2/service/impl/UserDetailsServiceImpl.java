package com.changinye.www.oauth2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.changinye.www.oauth2.mapper.UserInfoMapper;
import com.changinye.www.oauth2.model.UserInfo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("【Oauth2从数据库中查询｛｝用户的信息】", username);
		UserInfo userInfo = userInfoMapper.findByUsername(username);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority("暂不使用角色功能");
		authorities.add(sga);
		userInfo.setAuthorities(authorities);
		logger.info("【Oauth2打印用户信息】", userInfo);
		return userInfo;
	}

}
