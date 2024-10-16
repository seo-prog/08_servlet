package com.ohgiraffers.section01;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EncodingServlet implements Filter {
    // 기본 타입 설정해주는
    String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        encodingType = filterConfig.getInitParameter("encodingType");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (jakarta.servlet.http.HttpServletResponse) servletResponse;
        response.setContentType(encodingType);
        // response 에 setContentType 이 추가되는것.
        // 매번 인코딩 방식을 변경 할 필요가 없음.

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
