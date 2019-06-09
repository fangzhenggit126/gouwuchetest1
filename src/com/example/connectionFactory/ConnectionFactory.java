package com.example.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	ConnectionFactory connectionFactory=new ConnectionFactory();
   private ConnectionFactory()
   {
	 //加载数据库驱动程序
	   try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public  static Connection getConnection()
   {
	    //通过注册驱动程序管理器建立数据库连接
		String url="jdbc:mysql://localhost:3306/gouwuche?characterEncoding=utf8";
		String user="root";
		String password="123456";
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return conn;
   }
   public static void colse(ResultSet rs,Statement stm,Connection conn)
   {
	   try {
		   if(rs!=null)
		   {
				rs.close();
		   }
		   if(stm!=null)
		   {
			   stm.close();
		   }
		   if(conn!=null)
		   {
			   conn.close();
		   }
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   public static void colse(Statement stm,Connection conn)
   {
	   try {
		  
		   if(stm!=null)
		   {
			   stm.close();
		   }
		   if(conn!=null)
		   {
			   conn.close();
		   }
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   public static void colse(ResultSet rs,PreparedStatement ps,Connection conn)
   {
	   try {
		   if(rs!=null)
		   {
				rs.close();
		   }
		   if(ps!=null)
		   {
			   ps.close();
		   }
		   if(conn!=null)
		   {
			   conn.close();
		   }
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   public static void colse(PreparedStatement ps,Connection conn)
   {
	   try {
		  
		   if(ps!=null)
		   {
			   ps.close();
		   }
		   if(conn!=null)
		   {
			   conn.close();
		   }
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}
