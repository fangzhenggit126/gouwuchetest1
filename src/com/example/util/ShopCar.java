package com.example.util;

import java.util.ArrayList;

import com.example.bean.Goods;
/***
 * 购物车类其中buylist集合用来存储购物车里的商品
 * @author dell
 *
 */
public class ShopCar {
	//创建一个能够存储商品的列表对象，是用来存储购物车里的商品
	ArrayList buylist=new ArrayList();

	public ArrayList getBuylist() {
		return buylist;
	}
	/**
	 * @功能 向购物车中添加商品
	 * @参数 goods为Goods类对象，封装了要添加的商品信息
	 */
	public void addItem(Goods goods)
	{
		//判断添加到购物车里的商品是否为空
		if(goods!=null)
		{
			//判断购物车里是否存在商品
			if(buylist.size()==0)  //如果没有商品
			{
				//如果buylist中不存在任何商品,创建一个商品的临时对象
				Goods temp=new Goods();
				temp.setNo(goods.getNo());
				temp.setName(goods.getName());
				temp.setPrice(goods.getPrice());
				temp.setNum(1);
				//把该商品添加到购物车里
				buylist.add(temp);
			}
			else
			{
				int i=0;
				//遍历buylist集合对象，判断该购物车里是否已经存在当前要添加的商品	
				for(;i<buylist.size();i++)
				{
					//获取buylist集合中当前元素
					Goods temp=(Goods)buylist.get(i);
					if(temp.getNo()==goods.getNo())//如果相同，说明在购物车里已经存在了该商品，只需要将商品的购买数量加1
					{
						temp.setNum(temp.getNum()+1);
						//结束for循环
						break;
					}
				}
				if(i>=buylist.size())  //说明buylist中不存在要添加的商品
				{
					//创建一个商品的临时对象
					Goods temp=new Goods();
					temp.setNo(goods.getNo());
					temp.setName(goods.getName());
					temp.setPrice(goods.getPrice());
					temp.setNum(1);
					//把该商品添加到购物车里
					buylist.add(temp);
				}
			}
		}
	}
	/**
	 * @功能 从购物车中移除指定名称的商品
	 * @参数 no表示商品编号
	 */
	public void removeItem(int no){
		//遍历buylist集合，查找指定名称的商品
		for(int i=0;i<buylist.size();i++)
		{
			Goods temp=(Goods)buylist.get(i);
			if(temp.getNo()==no)
			{
				if(temp.getNum()>1)
				{
					temp.setNum(temp.getNum()-1);
				}
				else if(temp.getNum()==1)
				{
					buylist.remove(i);
				}
			}
		}
	}
	/**
	 * @功能 清空购物车
	 */
	public void clearCar(){
		buylist.clear();									//清空buylist集合对象
	}
}
