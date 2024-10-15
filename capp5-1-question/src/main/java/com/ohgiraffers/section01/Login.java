package com.ohgiraffers.section01;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();


        String username = req.getParameter("name");
        String phonenumber = req.getParameter("phonenumber");
        String password = req.getParameter("password");
        String passwordcheck = req.getParameter("passwordcheck");


        if ( username.length() <= 2) {
            out.println("<h1> 1입력 정보를 다시 확인해주세요</h1>");
            System.out.println(1);

        } else if ( phonenumber.length() != 11) {
            out.println("<h1> 2입력 정보를 다시 확인해주세요</h1>");

        }else if(password.length() < 8 ) {
            out.println("<h1>3입력 정보를 다시 확인해주세요</h1>");

        }else if(!password.equals(passwordcheck) ) {
            out.println("<h1>4입력 정보를 다시 확인해주세요</h1>");

        } else{
            out.println("<h1> 환영합니다 !! " + username + " 님 ~! </h1>");
            out.close();
        }


    }
}




