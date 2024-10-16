
package com.ohgiraffers.section01;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class RequestWrapper extends HttpServletRequestWrapper {
    // 필터로 암호화 해주는 역할

    /*
     * HttpServletRequestWrapper 클래스는 HttpServletRequest 인터페이스를 구현해놓은 클래스이다..
     * (인터페이스에 직접 접근해서 값을 수정할 수 없기에 wrapper 를 이용해서 수정하고 관리한다.)
     * 이 클래스는 request 객페의 요청 정보를 수정하거나 확장하는 용도로 사용한다..
     * 특정 파라미터의 값을 변경하거나 새로운 파라미터를 추가할 수 있다..
     * */

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



