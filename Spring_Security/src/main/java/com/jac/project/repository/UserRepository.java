package com.jac.project.repository;

import com.jac.project.exception.DatabaseException;
import com.jac.project.exception.UserNotFoundException;
import com.jac.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    UserDao userDao;
    public User newUser(User user){
        userDao.save(user);
//        try {
//            jdbcTemplate.update("insert into user (email, pword, flag) values(?,?,?)", user.getUsername(), user.getPassword(), user.getRole());
//        } catch (Exception e){
//            throw new DatabaseException("The email has been used, please change an other one.");
//        }
        return user;
    }

    public User updateUser(User user){
        userDao.save(user);
//        try {
//            jdbcTemplate.update("update user set pword = ? where email = ?", user.getUsername());
//        } catch (Exception e){
//            throw new DatabaseException("updateUser() is wrong.");
//        }
        return user;
    }

    public User getUserByEmail(String email){
        return userDao.findByEmail(email);
    }


}
