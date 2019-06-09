package com.example.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.bean.Goods;
import com.example.service.GoodsService;
import com.example.service.impl.GoodsServiceImpl;
import com.example.util.MyTools;
import com.example.util.ShopCar;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/docar")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String path="";
		   if(action==null)
			   action="";
		    ShopCar myCar=(ShopCar)request.getSession().getAttribute("myCar");
		  
		   if(action.equals("buy"))//购买商品
		   {
			   if(myCar==null)
			   {
				   myCar=new ShopCar();
			   }
			 //从数据库获取商品信息
				GoodsService goodsservice=new GoodsServiceImpl();
			   ArrayList goodslist=(ArrayList)goodsservice.getGoodsList();
			   int no=MyTools.strToint(request.getParameter("no"));
			   for(int i=0;i<goodslist.size();i++)
			   {
				   Goods goods=(Goods)goodslist.get(i);
				   if(goods.getNo()==no)
				   {
					   myCar.addItem(goods);		//调用ShopCar类中的addItem()方法添加商品
					   request.getSession().setAttribute("myCar", myCar);
					   path="dogoods";
				   }
			   }
		   }
		   else if(action.equals("remove"))//移除商品
		   {
			   int no=MyTools.strToint(request.getParameter("no"));		//获取商品编号
				myCar.removeItem(no);		//调用ShopCar类中的removeItem()方法移除商品
				path="shopcar.jsp";	//跳转到查看购物车页面	
		   }
		   else if(action.equals("clear")) //清空购物车
		   {
			   myCar.clearCar();				//调用ShopCar类中的clearCar()方法清空购物车
			   path="shopcar.jsp";  //跳转到查看购物车页面	
		   }
		   else
		   {
			   path="show3.jsp";  //跳转到商品列表页面		
			}
		 //通过分派器跳转到目的页面
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
