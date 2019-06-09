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
		//Ԥ��ִ��������
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Goods> goodslist=null;
		//��¼����
		int resultCount=0;
		try{
			   //�����ӹ�����ȡ����
			   conn=ConnectionFactory.getConnection();
			   String sql="select count(*) from goods";
				//���������ݿ�Ļ����Ͻ���һ��ִ��������
				ps=conn.prepareStatement(sql);
				//ͨ��ִ�������������ݿ������������ѯ��䣬������ѯ������ظ������ResultSet
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
					//�Խ��������ѭ������
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
