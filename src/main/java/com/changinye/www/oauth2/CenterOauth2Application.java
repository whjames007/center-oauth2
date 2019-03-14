package com.changinye.www.oauth2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CenterOauth2Application {

	private static Logger logger = LoggerFactory.getLogger(CenterOauth2Application.class);
	private static String name = "【Oauth2安全认证中心】";

	public static void main(String[] args) {
		SpringApplication.run(CenterOauth2Application.class, args);
		logger.info("【启动微服务成功】{}", name);
	}

}
