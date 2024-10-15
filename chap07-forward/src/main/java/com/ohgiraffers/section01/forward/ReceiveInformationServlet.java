package com.ohgiraffers.section01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        // 다른 서블릿으로 데이터를 request 의 setAttribute 로 전달한다..
        req.setAttribute("userId", userId);

        // print 라는 경로로 요청을 넘기기 위한 객체 생성
        // 이 경로는 서블릿이나 JSP 모두 가능!
        RequestDispatcher dispatcher = req.getRequestDispatcher("print");

        dispatcher.forward(req, resp);
        // 클라이언트는 인지를 못하지만 서블릿 내부적으로는 다른 서버로 넘긴것이다...
        // 다른 원래 받은 요청들은 보내면 꺼내쓸 수 있지만, 뭐 db 에서 뭐를  데이터를 꺼냈다거나
        // 그런 경우에는 따로 데이터를 위의 방법처럼 따로 넘겨줘야한다!


    }
}
