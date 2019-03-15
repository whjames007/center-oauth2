package com.changinye.www.oauth2.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.changinye.www.oauth2.model.UserInfo;

@Mapper
public interface UserInfoMapper {

	public UserInfo findByUsername(String username);	
}
