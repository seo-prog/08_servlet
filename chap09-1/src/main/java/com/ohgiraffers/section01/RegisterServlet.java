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

// 회원가입

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       // 회원가입에서 입력받은것을 암호화해준다. // 암호화해준 pw 이다.
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println(userId);
        System.out.println(password);


        HttpSession session = req.getSession();
        session.setAttribute("userID", userId);
        session.setAttribute("password", password);
        session.setMaxInactiveInterval(60 * 60 * 24);
        resp.sendRedirect("login.jsp");
        // 입력받은 아이디와 암호화 한 아이디 비번을 요청에 넣어 비교.




    }
}
