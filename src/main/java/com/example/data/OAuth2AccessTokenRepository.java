package com.example.data;

import com.example.data.OAuth2AuthenticationAccessToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * CODE CREDIT: https://github.com/Ekito/spring-multitenancy (NO LICENSE - ASK BEFORE ADDING TO PRODUCTION CODE)
 * Spring Data MongoDB repository for the OAuth2AuthenticationAccessToken entity.
 */
public interface OAuth2AccessTokenRepository extends MongoRepository<OAuth2AuthenticationAccessToken, String> {

    OAuth2AuthenticationAccessToken findByTokenId(String tokenId);

    OAuth2AuthenticationAccessToken findByRefreshToken(String refreshToken);

    OAuth2AuthenticationAccessToken findByAuthenticationId(String authenticationId);

    List<OAuth2AuthenticationAccessToken> findByClientIdAndUserName(String clientId, String userName);

    List<OAuth2AuthenticationAccessToken> findByClientId(String clientId);
}