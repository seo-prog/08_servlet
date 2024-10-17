package com.ohgiraffers.setion01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServlet;

@WebListener
public class ContextListenerTest implements ServletContextListener , ServletContextAttributeListener {

    /*
    * 리스너는 특정 이벤트 행위가 동작할 때 컨테이너에 의해 호출되는 메소드를 인털페이스로 정의 해두었다..
    * 이를 상속받아 구현한 메소드가 특정 이벤트 발생에 대해 필요한 로직을 작성하는데,
    * 크게 3가지 범주로 이벤트를 분류한다..
    *
    * 1. context (톰캣 컴체이너 자체에 리스너 연결)
    *   1-1: ServletContextListener : 웹 어플리케이션의 시작 및 종료에 대한 이벤트 리스너
    *    * -- init 이랑 비슷하지만 init 은 서블릿 내에 작동하지만 이거는 톰캣 전체에 적용이 가능하다.
    *   1-2: ServletContextAttributeListener : ServletContext 에 속성을 푸가, 제거, 수정 하는 것에 대한 이벤트 리스너
    *    * -- 특정 속성이 변경되었으 ㄹ때 개발자가 변화를 알고싶을 때 쓰인다..
    * */

    @Override
    public void contextInitialized(ServletContextEvent sce) {
      // context 가 생성될 때 변화를 감지하는 Listener 인스턴스가 함께 생성된다...
        // 최초 생성 시 생성자 호출 이후 동작 메소드
        System.out.println("context listener 인스턴스 생성 !");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       // context 가 소멸할 때 동작한다..
        System.out.println("context destroy !!");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("context Attribute added !!!");
        // context 의 attribute 가 추가될 때 동작한다..
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("context attribute removed!!!!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("context attribute replaced!!");
    }
}
