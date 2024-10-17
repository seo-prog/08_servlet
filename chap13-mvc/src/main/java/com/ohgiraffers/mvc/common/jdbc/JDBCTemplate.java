package com.ohgiraffers.mvc.common.jdbc;
import com.ohgiraffers.mvc.common.config.ConfigLocation;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// jdbc 연결을 관리하는 클래스 //

public class JDBCTemplate {


    // DB 연결을 생성하는 정적 메소드 .. gradle 에 sql 외부 라이브러리 추가해줘서 connection 쓸 수 있다.
    public static Connection getConnection() {

        Connection con = null;

        Properties prop = new Properties();
        System.out.println(con);

        try{
            System.out.println(ConfigLocation.CONNECTION_CONFIG_LOCATION);
            prop.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            System.out.println(url);


            Class.forName(driver);

            con = DriverManager.getConnection(url,user,password);
            System.out.println(con);

            con.setAutoCommit(false); // 실패했을 경우에 리셋을 시키려하기에 그러므로 autocommit 을 해준다.

        } catch(IOException e){
            throw new RuntimeException(e);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rest) {
        try {
            rest.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit (Connection con) {

        try {
            if(con != null && con.isClosed()) {
                con.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection con) {

        try {
            if(con != null && con.isClosed()) {
                con.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
