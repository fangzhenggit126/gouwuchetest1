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
import com.example.bean.User;
import com.example.service.GoodsService;
import com.example.service.UserService;
import com.example.service.impl.GoodsServiceImpl;
import com.example.service.impl.UserServiceImpl;
import com.example.util.MyTools;
import com.example.util.PageModel;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/douser")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String path="";
		if("login".equals(action))
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			UserService userservice=new UserServiceImpl();
			User user=userservice.Login(username, password);
			if(user!=null)
			{
				String pageIndex=request.getParameter("pageIndex");
				 PageModel pageModel=new PageModel();
				 //������ǵ�һ�η���show2.jspҳ��ʱ��pageIndex�϶�Ϊ��ֵ���������Ǿ�����pageIndex����Ҫ���ʵĵ�һҳ
				  if(pageIndex==null)
				  {
					  pageIndex="1";
				  }
				  pageModel.setPageIndex(MyTools.strToint(pageIndex));
				  
				//�����ݿ��ȡ��Ʒ��Ϣ
				GoodsService goodsservice=new GoodsServiceImpl();
				
				ArrayList<Goods> goodslist=goodsservice.getGoodsListByPageModel(pageModel);			//�����洢��Ʒ
		   		request.setAttribute("goodslist", goodslist);
		   		request.setAttribute("pageModel", pageModel);
		   		path="show3.jsp";
			}
		
		}
		else if("register".equals(action))
		{
			String username=request.getParameter("username");
			String cname=request.getParameter("cname");
			String password=request.getParameter("password");
			String sex=request.getParameter("sex");
			int age=MyTools.strToint(request.getParameter("age"));
			String address=request.getParameter("address");
			User user=new User();
			user.setUsername(username);
			user.setCname(cname);
			user.setPassword(password);
			user.setSex(sex);
			user.setAge(age);
			user.setAddress(address);
			UserService userservice=new UserServiceImpl();
			int i=userservice.register(user);
			if(i==1)
			{
				path="index.jsp";
			}
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
