package com.ohgiraffers.section01;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;

@WebFilter("/register/*")
public class Webfilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;

        RequestWrapper Wrapper = new RequestWrapper(hrequest);

        filterChain.doFilter(Wrapper, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
