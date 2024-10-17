package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.DTO.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
// 컨트롤러 ---> 서블릿
@WebServlet("/employee/list")
public class AllEmpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        EmployeeService employeeService = new EmployeeService();
        // 서비스랑 연결
        List<EmployeeDTO> allSelectEmp = employeeService.selectAllEmp();
        // 자료형은 List<EmployeeDTO> 로 서비스의 메소드 selectAllEmp 에 접근

        String path = "";

        if(allSelectEmp.size() > 0){
            path = "/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("empList", allSelectEmp);
        }else{
            path = "/WEB-INF/views/common/error.jsp";
            req.setAttribute("message", "직원 정보 조회 실패 !");
        }
        req.getRequestDispatcher(path).forward(req, resp);

    }
}
