package com.sf.hop.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.hop.user.dao.UserDAO;
import com.sf.hop.user.model.User;

@Service
public class UserService {
    @Autowired
    UserDAO userDao;
    
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }
}
