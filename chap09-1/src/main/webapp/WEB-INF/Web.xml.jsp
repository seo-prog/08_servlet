<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">

    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>com.ohgiraffers.section01.EncodingServlet</filter-class>
        <init-param>
            <param-name>encoding-type</param-name>
            <param-value>text/html;charset=UTF-8</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>
        <!--우리의 모든 요청은 이 코드 필터를 거친다는 뜻 ! -> /*-->
    </filter-mapping>
</web-app>