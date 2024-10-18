package com.ohgiraffers.mvc.common.jdbc;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


// jdbc 연결 관리
// DB 연결을 생성하는 정적 메소드 .. gradle 에 sql 외부 라이브러리 추가해야댐

import com.ohgiraffers.mvc.common.config.ConfigLocation;

import java.sql.Connection;
import java.util.Properties;

import static java.lang.Class.forName;

public class JDBCTemplate {

    public static Connection getConnection() {

        Connection con = null;

        Properties prop = new Properties();

            try {
                prop.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));

                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");

                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
                con.setAutoCommit(false);


            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
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
        try{
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit (Connection con) {

        try {
            if(con != null && !con.isClosed()) {
                con.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection con) {

        try {
            if(con != null && !con.isClosed()) {
                con.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}



