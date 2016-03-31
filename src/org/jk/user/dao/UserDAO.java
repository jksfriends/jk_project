package org.jk.user.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jk.common.DBConnect;

public class UserDAO {
	
	public List<UserDTO> getUserList() {
		
		List<UserDTO> resultList = new ArrayList<UserDTO>();
		
		Connection conn = DBConnect.getConnection();
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(" SELECT * FROM T_USER ");
			while(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setMynum((Integer)rs.getObject("MYNUM"));
				dto.setName((String)rs.getObject("NAME"));
				dto.setSex((String)rs.getObject("SEX"));
				dto.setAge((Integer)rs.getObject("AGE"));
				dto.setEmail((String)rs.getObject("EMAIL"));
				
				resultList.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultList;
	}
	
}
