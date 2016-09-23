package com.example.data;

import org.springframework.security.core.userdetails.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Admin on 9/12/16.
 */
public interface UserDetailsRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

}
