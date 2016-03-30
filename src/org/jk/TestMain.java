package org.jk;

import java.util.List;

import org.jk.user.dao.UserDAO;
import org.jk.user.dao.UserDTO;

public class TestMain {

	public static void main(String... args) {
		
		List<UserDTO> userList = new UserDAO().getUserList();
		
		for(UserDTO dto : userList) {
			System.out.println(dto);
		}
	}

}
