package com.data.session_06.controller;

import com.data.session_06.service.UserService;
import com.data.session_06.service.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/RegisterController")
public class RegisterController extends HttpServlet {
    private UserService userService = new UserServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));

        if (userService.register(user)) {
            resp.sendRedirect("login");
        } else {
            req.setAttribute("error", "Username already exists.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}