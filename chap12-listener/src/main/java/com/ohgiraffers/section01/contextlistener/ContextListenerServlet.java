package com.ohgiraffers.setion01.contextlistener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/context")
public class ContextListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("context listener 확인용 서블릿");

        ServletContext context = getServletContext(); // 얘는 만들어져 있는것 !
        // 톰캣이 실행될 때 전역적으로 하나 생기는 객체라고 봄
        /*
        * 웹 어픙리케이션의 전역 정보를 관리하는 객체,. 서버가 시작될 때 생성된다..
        * 어플리케이션에 하나만 존재한다.
        * 전체에서 공통으로 사용하는 데이터를 저장하거나 설정 정보를 공유할 떄 사용한다.
        * */

        context.setAttribute("test", "value");
        // context Attribute added !!! 가 동작되는것을 볼 수 있다..

        // 동일한 key 로 context 에 attr 를 추가하면(수정) Replaced 가 동작
        context.setAttribute("test", "value2");
        // context attribute replaced!! 동작

        context.removeAttribute("test");
        // context attribute removed!!!! 동작



    }
}
