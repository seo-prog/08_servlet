package com.ohgiraffers.mvc.employee.model.DAO;

import com.ohgiraffers.mvc.common.config.ConfigLocation;
import com.ohgiraffers.mvc.employee.model.DTO.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// sql 구문 꺼내오는 클래스

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {

    private final Properties prop;

    public EmployeeDAO() {

        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "employee-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeDTO selectEmpById(Connection con, String empId) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO selectEmp = null;

        String query = prop.getProperty("selectEmpById");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId); // 몇번째 물음표인지

            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectEmp = new EmployeeDTO();
                selectEmp.setEmpId(rset.getInt("EMP_ID"));
                selectEmp.setEmpName(rset.getString("EMP_NAME"));
                selectEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectEmp.setJobCode(rset.getString("JOB_CODE"));
                selectEmp.setSalary(rset.getInt("SALARY"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return selectEmp;

    }

    public List<EmployeeDTO> selectEmpList(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO row = null;

        List<EmployeeDTO> empList = null;
        empList = new ArrayList<>();
        String query = prop.getProperty("allSelect");

        try {
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();


            while (rset.next()) {
                row = new EmployeeDTO();
                row.setEmpId(rset.getInt("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("EMP_NO"));
                row.setEmail(rset.getString("Email"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("PHONE"));
                row.setDeptCode(rset.getString("DEPT_CODE"));
                row.setJobCode(rset.getString("JOB_CODE"));
                row.setSalLevel(rset.getString("SAL_LEVEL"));
                row.setSalary(rset.getInt("SALARY"));
                row.setBonus(rset.getDouble("BONUS"));
                row.setManagerId(rset.getString("MANAGER_ID"));
                row.setHireDate(rset.getDate("HIRE_DATE"));
                row.setEntDate(rset.getDate("ENT_DATE"));
                row.setEntYn(rset.getString("ENT_YN"));

                empList.add(row);
            }
            System.out.println(empList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return empList;
    }

}
