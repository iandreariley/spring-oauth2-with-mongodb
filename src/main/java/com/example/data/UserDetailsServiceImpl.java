package com.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Admin on 9/12/16.
 */
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        GrantedAuthority authority = new SimpleGrantedAuthority("admin");
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        auths.add(authority);
        User user = new User("user", "password", auths);

        if(!s.equals("user")) {
            throw new UsernameNotFoundException("User with username " + s + " not found");
        } else {
            return  user;
        }
    }

    public void addUser(User user) {
        userDetailsRepository.save(user);
    }
}
