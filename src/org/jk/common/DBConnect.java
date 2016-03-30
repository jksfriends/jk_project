package org.jk.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		String url = "jdbc:h2:tcp://localhost/~/test";	// 사용하려는 데이터베이스명을 포함한 URL 기술
		String id = "sa";								// 사용자 계정
		String pw = "";									// 사용자 계정의 패스워드

		try {
			Class.forName("org.h2.Driver");					// 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
			conn = DriverManager.getConnection(url,id,pw);	// DriverManager 객체로부터 Connection 객체를 얻어온다.
			System.out.println("제대로 연결되었습니다.");            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
