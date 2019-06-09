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
		  
		   if(action.equals("buy"))//������Ʒ
		   {
			   if(myCar==null)
			   {
				   myCar=new ShopCar();
			   }
			 //�����ݿ��ȡ��Ʒ��Ϣ
				GoodsService goodsservice=new GoodsServiceImpl();
			   ArrayList goodslist=(ArrayList)goodsservice.getGoodsList();
			   int no=MyTools.strToint(request.getParameter("no"));
			   for(int i=0;i<goodslist.size();i++)
			   {
				   Goods goods=(Goods)goodslist.get(i);
				   if(goods.getNo()==no)
				   {
					   myCar.addItem(goods);		//����ShopCar���е�addItem()���������Ʒ
					   request.getSession().setAttribute("myCar", myCar);
					   path="dogoods";
				   }
			   }
		   }
		   else if(action.equals("remove"))//�Ƴ���Ʒ
		   {
			   int no=MyTools.strToint(request.getParameter("no"));		//��ȡ��Ʒ���
				myCar.removeItem(no);		//����ShopCar���е�removeItem()�����Ƴ���Ʒ
				path="shopcar.jsp";	//��ת���鿴���ﳵҳ��	
		   }
		   else if(action.equals("clear")) //��չ��ﳵ
		   {
			   myCar.clearCar();				//����ShopCar���е�clearCar()������չ��ﳵ
			   path="shopcar.jsp";  //��ת���鿴���ﳵҳ��	
		   }
		   else
		   {
			   path="show3.jsp";  //��ת����Ʒ�б�ҳ��		
			}
		 //ͨ����������ת��Ŀ��ҳ��
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
