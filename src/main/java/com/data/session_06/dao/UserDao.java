package com.data.session_06.dao;

import com.data.session_06.model.User;

public interface UserDao {
    User getUserByUsernameAndPassword(String username, String password);
    boolean addUser(User user);
    User getUserByUsername(String username);
}
