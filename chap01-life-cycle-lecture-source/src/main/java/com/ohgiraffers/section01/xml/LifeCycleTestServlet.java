package com.ohgiraffers.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet{

    /*
    * 서블릿에서 XML 매핑과 어노테이션 매핑은 둘 다 서블릿과 url 을 연결하는 방법이다 ..
    * 현재는 어노테이션 방식을 훨씬 더 많이 사용한다..
    * 그 이유는 어노테이션이 가지는 여러 가지 장점 때문 ..
    *
    * xml 방식 - 과거 방식으로, web.xml 파일에 서블릿을 등록하고 매핑(연결)하는 방식..
    * -- 쭉 다 만들어두면 뭐가 뭔지 찾기 어렵다.
    *
    * 단점
    * - 장황함, 유연성 부족, 가독성 저하
    *
    * */

    private int initCount = 1;
    private int serviceCount = 1;
    private int destoryCount = 1;

    // 서블릿 컨테이너에 의해 최초 요청에만 실행되는 메소드
    // 서버에 요청이 날라오기 전에 준비작업을 해두는 메소드라고 보면 된다..(뭐 BD 랑 연결을 해준다거나 등등...)
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init() 호출:" + initCount++);
    }


    @Override // 이 클래스나 메소드 위에 있는 @뭐시기가 annotation 이다 !
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("xml 매핑 service() 호출 " + serviceCount++);
        // 최초 요청 시에는 init() 이후에 동작하고,
        // 두 번째 요청 부터는 init() 호출 없이 바로 호출된다..
    }

    // 모든 http 요청이 먼저 전달되는 메소드이다..
    // 실질적으로 요청이 들어왔을 때, 적절하게 어떤 메소드를 필요로 하는지 결정하는 메소드이다.
    // 매칭해주는 서비스는 구현이 자동으로 되어있기에 우리가 따로 만질필요는 없다.
    // 요청의 http 메소드에 따라 적절하게 doGet(), doPost() 등을 호출한다..


    // 컨테이너가 종료될 때 호출되는 메소드잉며, 주로 자원을 반납하는 용도로 사용한다..
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destory() 호출 : " + destoryCount++);
    }
}
