package com.example.dao;

import com.example.bean.User;

public interface UserDao {
   //��½
	public User Login(String username,String password);
  //ע��
	public int register(User user);
}
