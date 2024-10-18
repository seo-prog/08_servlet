package com.ohgiraffers.mvc.common.filter;

import com.ohgiraffers.mvc.common.config.ConfigLocation;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebFilter("/*") // 모든 요청에 필터 적용
public class ContextConfigFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // DB 접속 설정 정보 파일의 경로가 비어 있는 경우에 초기화 해준다..
        // 최초 요청 시 DB 접속 경로와 매퍼 파일 경로를 설정해준다..

        if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null){
            String root = servletRequest.getServletContext().getRealPath("/");
            System.out.println(root);


            String connectionInfoPath = servletRequest.getServletContext().getInitParameter("connection-info");
            //  파일이 존재하는 곳
            System.out.println("DB 접속경로 설정 완료 !");
            System.out.println(root+"/"+connectionInfoPath);
            ConfigLocation.CONNECTION_CONFIG_LOCATION = root+"/"+connectionInfoPath;
            // 첫번째 서버 주소와 내부에 properties 파일이 존재하는 경로를 두개 합쳐준다.
        }

        if(ConfigLocation.MAPPER_LOCATION == null){
            String root = servletRequest.getServletContext().getRealPath("/");
            String mapperLocation = servletRequest.getServletContext().getInitParameter("mapper-location");

            System.out.println("매퍼 설정 완료");
            ConfigLocation.MAPPER_LOCATION = root+"/"+mapperLocation;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
