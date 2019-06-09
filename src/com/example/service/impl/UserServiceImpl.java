package com.example.service.impl;

import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {
   UserDao userdao=new UserDaoImpl();
	@Override
	public User Login(String username, String password) {
		// TODO Auto-generated method stub
		return userdao.Login(username, password);
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		return userdao.register(user);
	}

}
