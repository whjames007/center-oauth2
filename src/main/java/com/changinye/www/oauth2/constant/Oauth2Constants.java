package com.changinye.www.oauth2.constant;

public class Oauth2Constants {
	/**
	 * JSON Web
	 * Token（JWT）是一种开放的标准（RFC7519）,JWT定义了一种紧凑且自包含的标准，该标准旨在将各个主体的信息、包装为JSON对象。
	 * 基于keytool生成私钥和公钥
	 */
	// jwt别名
	public static final String JWT_ALIAS = "gewei-jwt";
	public static final String JWT_ALIAS2 = "changinye-jwt";
	// jwt文件名称
	public static final String JWT_FILENAME = "changinye-jwt.jks";
	// jwt密码
	public static final String JWT_PASSWORD = "Gewei#027";
	public static final String JWT_PASSWORD2 = "CHANginye#027";

	// oauth2的客户端ID（全局统一）
	public static final String CLIENT_ID = "clientIdForGewei";
	public static final String CLIENT_ID2 = "clientIdForChanginye";
	// oauth2的客户端密码（全局统一）
	public static final String CLIENT_SECRET = "clientSecretFor#027";
	// oauth2的token时效（10小时，全局统一）
	public static final Integer TOKEN_VALID_SECOND = 36000;

}
