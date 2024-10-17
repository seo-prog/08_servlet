
package com.ohgiraffers.section01;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class RequestWrapper extends HttpServletRequestWrapper {
    // 필터로 암호화 해주는 역할

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {

        String value = "";
        if("password".equals(name)) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(name));
            // 복호화도 안되서 원문을 알 수 없다. 그러니 원문과 암호화가 된 암호문과 비교를 한다.

        }else{
            value = super.getParameter(name); // 원래 쓰던 getParameter 처럼 그냥 써준다 생각.
        }

        return value;

    }
}



