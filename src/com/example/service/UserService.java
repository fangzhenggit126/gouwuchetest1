package com.example.service;

import com.example.bean.User;

public interface UserService {
	//µÇÂ½
	public User Login(String username,String password);
	 //×¢²á
	public int register(User user);
}
