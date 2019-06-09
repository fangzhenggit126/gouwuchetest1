package com.example.dao;

import com.example.bean.User;

public interface UserDao {
   //µÇÂ½
	public User Login(String username,String password);
  //×¢²á
	public int register(User user);
}
