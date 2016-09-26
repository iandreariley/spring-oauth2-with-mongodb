package com.example;

import com.example.data.*;
import com.example.server.security.MongoDBTokenStore;
import com.example.server.security.OAuthConfiguration;
import com.example.server.security.SecurityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@SpringBootApplication(scanBasePackages = {"com.example"})
public class Example {

	@Autowired
	OAuth2AccessTokenRepository oAuth2AccessTokenRepository;

	@Autowired
	OAuth2RefreshTokenRepository oAuth2RefreshTokenRepository;

	@Autowired
	ClientDetailsRepository clientDetailsRepository;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@RequestMapping("/")
	String home() {
		return "Hello young man.";
	}

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
				.sources(Example.class)
				.build()
				.run(args);
	}

	@Bean
	AuthorizationServerConfigurer authorizationServerConfigurer() {
		return new OAuthConfiguration();
	}

	@Bean
	ClientDetailsService clientDetailsService() {
		return new ClientDetailsServiceImpl();
	}

	@Bean
	UserDetailsServiceImpl userDetailsService() {
		GrantedAuthority authority = new SimpleGrantedAuthority("admin");
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths.add(authority);
		User user = new User("user", "password", auths);
		userDetailsRepository.save(user);
		return new UserDetailsServiceImpl();
	}

	@Bean
	SecurityServer securityServer() {
		return new SecurityServer();
	}

	@Bean
	TokenStore tokenStore() {
		return new MongoDBTokenStore(oAuth2AccessTokenRepository, oAuth2RefreshTokenRepository);
	}
}