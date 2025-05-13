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
    public boolean login(String username, String password) {
        return userDao.getUserByUsernameAndPassword(username, password) != null;
    }

    @Override
    public boolean register(User user) {
        if (userDao.getUserByUsername(user.getUsername()) == null) {
            return userDao.addUser(user);
        }
        return false;
    }
}
