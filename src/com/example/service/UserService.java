package com.example.service;

import com.example.bean.User;

public interface UserService {
	//��½
	public User Login(String username,String password);
	 //ע��
	public int register(User user);
}
