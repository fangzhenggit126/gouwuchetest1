package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.bean.User;
import com.example.connectionFactory.ConnectionFactory;
import com.example.dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public User Login(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try
		{
			conn=ConnectionFactory.getConnection();
			String sql="select * from user where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					if(password.equals(rs.getString("password")))
					{  
						user=new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setCname(rs.getString("cname"));
						user.setPassword(rs.getString("password"));
						user.setSex(rs.getString("sex"));
						user.setAge(rs.getInt("age"));
						user.setAddress(rs.getString("address"));
						break;
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionFactory.colse(rs, ps, conn);
		}
		return user;
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		Connection  conn=null;
		//预制执行语句对象
		PreparedStatement ps=null;
		int i=0;
		try {
			    //从连接工厂获取连接
				conn=ConnectionFactory.getConnection();
				String sql="insert into user (username,cname,password,sex,age,address)values(?,?,?,?,?,?)";
				//在连接数据库的基础上建立一个执行语句对象
				ps=conn.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getCname());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getSex());
				ps.setInt(5, user.getAge());
				ps.setString(6, user.getAddress());
				//通过执行语句对象向数据库服务器发出执行语句，
				i=ps.executeUpdate();
				if(i==1)
				{
					System.out.println("添加成功");
				}
				else
				{
					System.out.println("添加失败");
				}
				
			} 
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					
		}
		finally{
			ConnectionFactory.colse(ps, conn);;
			
		}
		return i;
	}

}
