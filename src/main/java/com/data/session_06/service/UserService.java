package com.data.session_06.service;

import com.data.session_06.model.User;

public interface UserService {
    User getUserByUsernameAndPassword(String username, String password);
    boolean addUser(User user);
    User getUserByUsername(String username);
}
