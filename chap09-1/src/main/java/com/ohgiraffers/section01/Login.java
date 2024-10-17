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

@WebServlet("/login")
public class Login extends HttpServlet {

        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            HttpSession session = req.getSession();

            // 암호화 된걸 받은 session 으로 받은 아이디와 비번
            String userId2= (String) session.getAttribute("userId");
            String password2 = (String) session.getAttribute("password");

            // 입력받은 아이디 비번
            String userId = req.getParameter("userId");
            String password = req.getParameter("password");

            boolean result = false;
            boolean result2 = false;

            System.out.println(userId2);
            System.out.println(password2);

           if(userId2 == null || password2 == null){
                resp.sendRedirect("login.jsp");
                return;
            }
            else {
                BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
                System.out.println(" 비밀번호가 pass01 인지 확인 : ");
                result = bcrypt.matches(password, password2);
                result2 = userId.equals(userId2);
            }

            if(result && result2) {
                req.setAttribute("userId", userId);
                req.setAttribute("password", password);
                RequestDispatcher dispatcher = req.getRequestDispatcher("main");
                dispatcher.forward(req, resp);

            }else{
                resp.sendRedirect("login.jsp");
            }


    }


}
