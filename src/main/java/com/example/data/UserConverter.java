package com.example.data;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ianriley on 9/23/16.
 */
public class UserConverter implements Converter<DBObject, User> {

    public User convert(DBObject dbObject) {
        String username = (String) dbObject.get("username");
        String password = (String) dbObject.get("password");
        Collection<GrantedAuthority> auths = castToAuthorities((BasicDBList) dbObject.get("authorities"));

        return new User(username, password, auths);
    }

    private Collection<GrantedAuthority> castToAuthorities(BasicDBList dbAuthorityObjects) {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Object o : dbAuthorityObjects) {
            DBObject rawObject = (DBObject) o;
            String role = (String) rawObject.get("role");
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }
}
