package com.changinye.www.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import com.changinye.www.oauth2.constant.Oauth2Constants;

/**
 * @EnableAuthorizationServer = 开启授权服务
 *
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Bean
	protected JwtAccessTokenConverter jwtTokenEnhancer() {
		JwtAccessTokenConverter jatc = new JwtAccessTokenConverter();
		KeyStoreKeyFactory kskf = new KeyStoreKeyFactory(new ClassPathResource(Oauth2Constants.JWT_FILENAME),
				Oauth2Constants.JWT_PASSWORD.toCharArray());
		jatc.setKeyPair(kskf.getKeyPair(Oauth2Constants.JWT_ALIAS));
		return jatc;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtTokenEnhancer());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients.inMemory().withClient(Oauth2Constants.CLIENT_ID).secret(Oauth2Constants.CLIENT_SECRET).scopes("server")
				.authorizedGrantTypes("refresh_token", "password")
				.accessTokenValiditySeconds(Oauth2Constants.TOKEN_VALID_SECOND);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
		endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtTokenEnhancer())
				.authenticationManager(authenticationManager);
	}
}
