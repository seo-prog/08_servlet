package com.ohgiraffers.mvc.employee.controller;


import com.ohgiraffers.mvc.employee.model.DTO.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String empId = req.getParameter("empId");
        System.out.println("empId = " + empId);


        // 사번을 이용해 사원 정보를 조회하는 비즈니스 로직 호출
        EmployeeService empService = new EmployeeService();
        EmployeeDTO selectEmp = empService.selectOneEmpById(empId); // 서비스 안의 메소드 호출

        System.out.println("selectEmp = " + selectEmp);

        // 실행 결과에 따라서 뷰 연결
        String path = "";
        if(selectEmp != null) {
            path = "/WEB-INF/views/employee/showEmpInfo.jsp"; // 하나의 인덱스에서만 하는게 아니므로 경로를 늘 지정해줘야 한다.
            req.setAttribute("selectEmp", selectEmp); // selectEmp 에서 꺼내오게 해뒀으니까
        } else{
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 정보 조회 실패");
        }

        req.getRequestDispatcher(path).forward(req, resp);

    }
}
