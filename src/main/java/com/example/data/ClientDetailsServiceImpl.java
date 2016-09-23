package com.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 9/12/16.
 */
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    ClientDetailsRepository clientDetailsRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails client = clientDetailsRepository.findByClientId(clientId);

        if(client == null) {
            throw new ClientRegistrationException("We lost, boss!");
        } else {
            return client;
        }
    }

    public void addClient(BaseClientDetails client) {
        clientDetailsRepository.save(client);
    }
}
