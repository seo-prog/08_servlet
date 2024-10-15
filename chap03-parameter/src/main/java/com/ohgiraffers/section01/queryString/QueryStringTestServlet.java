package com.ohgiraffers.section01.queryString;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {
    // servlet 메소드는 HttpServlet 에 들어있고 어느 doget 으로 갈지는 실행될 때 동적바인딩이 일어난다.
    // 서블릿마다 doget 이 있으니까 어느 서블릿 메소드의 doget 으로 갈지
    // 기본적으로 서비스 메소드가 실행되면서 그 안에 있는 doget 이 실행되게 되는데 그 doget 이 어느 메소드의 doget 인지는
    // 실행되는 순간에 정해진다/ 그 요청에 따라서 / 동적바인딩으로 구현이 된다ㅣ.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // service 로 부터 전달받은 HttpServiceRequest 는 요청 시 전달한 값을 getParameter() 로 추출할 수 있다..
        // 이 때 인자로 input 태그에 지정한 name 속성의 값을 문자열 형태로 전달하면 된다..
        String name = req.getParameter("name"); // 값 꺼냄
        System.out.println(" 이름 : " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("나이 : " + age);

        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println(" 생일 : " + birthday);

        // radio 태그는 여러 값 중 선택된 하나의 값만 전달된다..
        String gender = req.getParameter("gender");
       System.out.println(" 성별 : " + gender);

        // selectbox 도 동일하다
        String national = req.getParameter("national");
        System.out.println(" 국적 : " + national);

        // checkbox 는 다중으로 입력을 받을 수 있어, 선택된 값이 문자열 배열로 전달된다..
        System.out.println(" 취미 : ");
        String[] hobby = req.getParameterValues("hobbies");

        for (String hobbys : hobby) {
            System.out.println(hobbys);


            /*
            * getParameterMap() - 모든 데이터를 jey, value 형태로 일괄 변환
            *
            * */
            Map<String, String[]> requestMap = req.getParameterMap();

            for (String key : requestMap.keySet()) {
                System.out.println();
                System.out.println(key);
                for (String value : requestMap.get(key)) {
                    System.out.print(value );
                }
            }
        }}}
