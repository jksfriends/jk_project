package org.jk.user.service;

import java.util.List;

import org.jk.user.dao.UserDAO;
import org.jk.user.dao.UserDTO;

public class UserServiceImpl implements UserService {
	
	private UserDAO dao = new UserDAO();
	
	@Override
	public List<UserDTO> getUserList() {
		return dao.getUserList();
	}
	
	
}
