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

       HttpSession session = req.getSession();
        // 여기서 우리가 만들어뒀던 필터를 거쳐서 암호화 된 비밀번호가 요청으로 온다 !
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        String userId2= (String) session.getAttribute("userId");
       String password2 = (String) session.getAttribute("password");
        PrintWriter out = resp.getWriter();


        resp.setContentType("text/html;charset=UTF-8");
        boolean result = false;
        boolean result2 = false;
        if (userId == null || password == null) {
            out.println("<h1> 입력이 없습니다 !!!<h1>");
        }
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        System.out.println(" 비밀번호가 pass01 인지 확인 : ");
        result = bcrypt.matches("password", password2); // 암호화 된 내용을 2번쨰 인자로 전달해야 한다..
        result2 = userId.equals(userId2);

        if(result && result2) {
            out.println("<h1> 환영합니다 ! " + userId + "님 !! </h1>");
            out.flush();
            out.close();
            resp.sendRedirect("/main");
        }else{
            out.println("<h1>땡 !!!!</h1>");
        }


    }
}
