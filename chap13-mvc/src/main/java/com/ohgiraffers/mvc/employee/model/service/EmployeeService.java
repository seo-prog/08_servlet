package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.DAO.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.DTO.EmployeeDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.getConnection;

public class EmployeeService {

    private final EmployeeDAO empDAO;

    public EmployeeService() {
        empDAO = new EmployeeDAO();  //서비스가 호출될 때 empDAO 도 같이 호출이 된다. 기본생성자이기 때문에 !
    }


    public EmployeeDTO selectOneEmpById(String empId) {

        Connection con = getConnection();

        EmployeeDTO selectEmp = empDAO.selectEmpById(con, empId);

        close(con);

        return selectEmp;
    }

    public List<EmployeeDTO> selectAllEmp() {
        Connection con = getConnection();

        List<EmployeeDTO> allSelect = empDAO.selectEmpList(con);
        //  자료형은 List<EmployeeDTO> 로 empDAO에 접근해서  selectEmpList(con) 메소드로 이동
        close(con);
        return allSelect;

    }
}
