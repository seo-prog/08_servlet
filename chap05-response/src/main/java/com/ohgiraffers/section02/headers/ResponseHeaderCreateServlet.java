package com.ohgiraffers.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;


@WebServlet("/headers")
public class ResponseHeaderCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        long currentTime = System.currentTimeMillis();

        out.println("<h1>" + currentTime + "</h1>");
        out.close();

        Collection<String> responseHeaders = resp.getHeaderNames();
        Iterator<String> iterator = responseHeaders.iterator();
// response 도 header 가 있구나. 클라이언트에게 도움이 될 정보를 가지고 있구나 정도로만 생각하고 넘어가삼

        while (iterator.hasNext()) {
            String headerName = iterator.next();
            System.out.println(headerName + ": " + resp.getHeader(headerName));
        }

    }
}
