package com.example.data;

import com.example.data.OAuth2AuthenticationRefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * CODE CREDIT: https://github.com/Ekito/spring-multitenancy (NO LICENSE - ASK BEFORE ADDING TO PRODUCTION CODE)
 * Spring Data MongoDB repository for the OAuth2AuthenticationRefreshToken entity.
 */
public interface OAuth2RefreshTokenRepository extends MongoRepository<OAuth2AuthenticationRefreshToken, String> {

    public OAuth2AuthenticationRefreshToken findByTokenId(String tokenId);
}