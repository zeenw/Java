package com.jac.project.service;

import com.jac.project.model.ResponseData;
import com.jac.project.model.Role;
import com.jac.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jac.project.repository.UserDao;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        if(user == null)
            throw new UsernameNotFoundException("Email is not find.");
        return user;
    }




}
