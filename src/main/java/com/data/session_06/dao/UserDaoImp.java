package com.data.session_06.dao;

import com.data.session_06.model.User;
import com.data.session_06.utils.ConnectionDB;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class UserDaoImp implements UserDao {
    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        User user = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_user_by_username_password(?, ?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return user;
    }

    @Override
    public boolean addUser(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_user(?, ?, ?, ?)}");
            callSt.setString(1, user.getUsername());
            callSt.setString(2, user.getPassword());
            callSt.setString(3, user.getEmail());
            callSt.setString(4, user.getPhone());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public User getUserByUsername(String username) {
        Connection conn = null;
        CallableStatement callSt = null;
        User user = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_user_by_username(?)}");
            callSt.setString(1, username);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return user;
    }

}
