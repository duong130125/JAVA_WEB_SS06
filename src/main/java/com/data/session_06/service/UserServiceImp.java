package com.data.session_06.service;

import com.data.session_06.dao.UserDao;
import com.data.session_06.dao.UserDaoImp;
import com.data.session_06.model.User;

public class UserServiceImp implements UserService{
    private final UserDao userDao;

    public UserServiceImp() {
        userDao = new UserDaoImp();
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userDao.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
