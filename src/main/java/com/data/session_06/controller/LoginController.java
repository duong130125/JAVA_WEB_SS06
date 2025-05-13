package com.data.session_06.controller;

import com.data.session_06.service.UserService;
import com.data.session_06.service.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    private UserService userService = new UserServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.login(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("books");
        } else {
            req.setAttribute("error", "Invalid username or password.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}