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
import com.example.util.PageModel;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/dogoods")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String pageIndex=request.getParameter("pageIndex");
		 PageModel pageModel=new PageModel();
		  if(pageIndex==null)
		  {
			  pageIndex="1";
		  }
		  pageModel.setPageIndex(MyTools.strToint(pageIndex));
		  
		//从数据库获取商品信息
		GoodsService goodsservice=new GoodsServiceImpl();
		
		ArrayList<Goods> goodslist=goodsservice.getGoodsListByPageModel(pageModel);			//用来存储商品
  		request.setAttribute("goodslist", goodslist);
  		request.setAttribute("pageModel", pageModel);
  		String path="show3.jsp";
  		 //通过分派器跳转到指定的页面
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
