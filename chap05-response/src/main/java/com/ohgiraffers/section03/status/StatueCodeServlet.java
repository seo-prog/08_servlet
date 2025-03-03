package com.ohgiraffers.section03.status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/status")
public class StatueCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       //  resp.sendError(404," 없는 페이지 입니다. 경로를 확인해주세요");
        // 404 는 주로 사용자의 잘못에 의해 이동한 (잘못된경로)
        resp.sendError(500, "서버 내부 오류입니다.. 서버 오류는 개발자의 잘못이고, 개발자는 여러분입니다.");
    }
}
