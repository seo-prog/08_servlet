package com.ohgiraffers.section01.exeption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/show500error")
public class Show500ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(500, "500번 에러는 누구 잘못? 개!!!발!!!자!!!!!!!!!!!!!!!!!!!!!!!!");

    }
}
