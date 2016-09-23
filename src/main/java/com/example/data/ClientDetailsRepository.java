package com.example.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public interface ClientDetailsRepository extends MongoRepository<BaseClientDetails, String> {

    BaseClientDetails findByClientId(String clientId);

}
