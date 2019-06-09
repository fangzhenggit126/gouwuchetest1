package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bean.Goods;
import com.example.connectionFactory.ConnectionFactory;
import com.example.dao.GoodsDao;
import com.example.util.PageModel;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public ArrayList<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Goods> goodslist=null;
				try
				{
					conn=ConnectionFactory.getConnection();
					String sql="select * from goods";
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					if(rs!=null)
					{
						goodslist=new ArrayList<Goods>();
						while(rs.next())
						{
							Goods goods=new Goods();
							goods.setNo(rs.getInt("no"));
							goods.setName(rs.getString("name"));
							goods.setPrice(rs.getFloat("price"));
							goods.setStore(rs.getInt("store"));
							goodslist.add(goods);
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
				return goodslist;
	}

	@Override
	public ArrayList<Goods> getGoodsListByPageModel(PageModel pageModel) {
		Connection conn=null;
		//预制执行语句对象
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Goods> goodslist=null;
		//记录总数
		int resultCount=0;
		try{
			   //从连接工厂获取连接
			   conn=ConnectionFactory.getConnection();
			   String sql="select count(*) from goods";
				//在连接数据库的基础上建立一个执行语句对象
				ps=conn.prepareStatement(sql);
				//通过执行语句对象向数据库服务器发出查询语句，并将查询结果返回给结果集ResultSet
				rs=ps.executeQuery();
				while(rs.next())
				{
					resultCount=rs.getInt(1);
				}
				if(resultCount==0)
				{
					return goodslist;
				}
				pageModel.setResultCount(resultCount);
				sql="select * from goods limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, pageModel.getStartPosition());
				ps.setInt(2, pageModel.getResultlimit());
				rs=ps.executeQuery();
				if(rs!=null)
				{
					goodslist=new ArrayList<Goods>();
					//对结果集进行循环遍历
					while(rs.next())
					{
						Goods goods=new Goods();
						goods.setNo(rs.getInt("no"));
						goods.setName(rs.getString("name"));
						goods.setPrice(rs.getFloat("price"));
						goods.setStore(rs.getInt("store"));
						goodslist.add(goods);
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionFactory.colse(rs, ps, conn);;
		}
		return goodslist;
	}

}
