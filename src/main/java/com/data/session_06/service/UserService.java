package com.data.session_06.service;

import com.data.session_06.model.User;

public interface UserService {
    boolean login(String username, String password);
    boolean register(User user);
}
