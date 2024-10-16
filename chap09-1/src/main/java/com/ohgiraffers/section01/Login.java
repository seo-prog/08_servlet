package com.ohgiraffers.section01;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

@WebServlet("/first/login")
public class Login extends HttpServlet {

        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String userId = req.getParameter("username");
            String password = req.getParameter("password");

            HttpSession session = req.getSession();
            session.setAttribute("userID", userId);
            session.setAttribute("password", password);
            session.setMaxInactiveInterval(60 * 60 * 24);
            resp.sendRedirect("/register");

    }
}
