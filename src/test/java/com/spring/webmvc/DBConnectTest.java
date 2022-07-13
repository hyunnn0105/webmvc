package com.spring.webmvc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectTest {
    private String uid = "hr";
    private String upw = "hr";
    // 데이터 베이스의 위치정보 (DB URL)
    private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    // 데이터베이스 접속에 쓸 드라이버 클래스
    private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";

    @Test
    void ConnectTest(){

        try{
            Class.forName(DRIVER);

            Connection conn = DriverManager.getConnection(URL,uid, upw);
            String sql = "SELECT first_name FROM employees";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("first_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
