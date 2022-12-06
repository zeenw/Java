package com.jac.project.service;



import com.jac.project.exception.DatabaseException;
import com.jac.project.exception.UserNotFoundException;
import com.jac.project.model.ResponseData;
import com.jac.project.model.Role;
import com.jac.project.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


import com.jac.project.model.User;
import com.jac.project.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public ResponseData login(User user){
        ResponseData responseData = new ResponseData();
        try {
            User userDB = userDao.findByEmail(user.getUsername());
            responseData.setMessage("1");
            responseData.setObject(userDB);

        } catch(Exception e){
            throw new DatabaseException(e.getMessage());
        }

        return responseData;
    }
    public User newUser(User user){
        User userData = new User();
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        if(getUserByEmail(user.getUsername()) == null) {
            userData.setEnabled(true);
            userData.setCredentialsNonExpired(true);
            userData.setAccountNonExpired(true);
            userData.setAccountNonLocked(true);
            userData.setRoles(Arrays.asList(new Role("ROLE_user")));
            userData.setPword(pwEncoder.encode(user.getPassword()));
            userData.setEmail(user.getUsername());
            userDao.save(userData);
            return userData;
        } else {
            return null;
        }

    }

    public User getUserByEmail(String email){
        return userDao.findByEmail(email);

    }





}
