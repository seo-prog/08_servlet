package com.ohgiraffers.section02.formdata;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 톰캣 서버 인코딩 설정 방식
        System.out.println(req.getCharacterEncoding()); // 톰캣 서버의 default 방식

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println("name : " + name);
        // 인코딩을 제외한 값들은 GET 방식과 동일하게 꺼낼 수 있다..

        Map<String, String[]> requesMap = req.getParameterMap();
        Set<String> keys = requesMap.keySet(); // set 은 반복문을 사용할 수 없다.
        Iterator<String> iterator = keys.iterator(); // 반복자로 반복문 사용 가능

        // get 이랑 똑같고 주소에 노출 되냐 안되냐의 차이만 가짐
        while (iterator.hasNext()) {
            String key = iterator.next();
            String[] values = requesMap.get(key);
            System.out.println("key : " + key );
            for(int i = 0; i < values.length; i++) {
                System.out.println("value [" + i + "] : " + values[i]);
            }
        }


    }
}
