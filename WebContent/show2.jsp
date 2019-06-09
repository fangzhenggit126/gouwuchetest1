<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.example.bean.Goods" %>
    <%@ page import="com.example.util.PageModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%	
   ArrayList goodslist=(ArrayList)request.getAttribute("goodslist");	
   PageModel pageModel=(PageModel)request.getAttribute("pageModel");	
 %>
<body>
  <table border="1" width="450" rules="none" cellspacing="0" cellpadding="0">
     <tr height="50">
        <td colspan="3" align="center">提供商品如下</td>
     </tr>
     <tr align="center" height="30" bgcolor="lightgrey">
        <td>名称</td>
	    <td>价格(元/斤)</td>
		<td>购买</td>
     </tr>
     <%
        if(goodslist==null||goodslist.size()==0){ 
     %>
        <tr height="100">
          <td colspan="3" align="center">没有商品可显示！</td>
        </tr>
     <% 	
        }
        else
        {
        	for(int i=0;i<goodslist.size();i++)
        	{
        		Goods goods=(Goods)goodslist.get(i);
        	
     %> 
           <tr height="50" align="center">
		      <td><%=goods.getName()%></td>
		     <td><%=goods.getPrice()%></td>
		     <td><a href="docar?action=buy&no=<%=goods.getNo()%>">购买</a></td>
	      </tr>
     <%
        	}
       } 
     %>
     <tr height="50">
       <td align="center" colspan="3">
        <%
            if(pageModel.getPageIndex()==1)
            {
        %>
              [首页]&nbsp;[上一页]&nbsp;&nbsp;
        <% 
        
            }
           if(pageModel.getPageIndex()>1)
           {
        %>
              <a href="dogoods?pageIndex=1">[首页]</a>&nbsp;
              <a href="dogoods?pageIndex=<%=pageModel.getPageIndex()-1%>">[上一页]</a>&nbsp;&nbsp;
        <%	
           }
           if(pageModel.getPageIndex()==pageModel.getPageTotal())
           {
        %>
               [下一页]&nbsp;[尾页]&nbsp;&nbsp;
        <% 	   
           }
           if(pageModel.getPageIndex()<pageModel.getPageTotal())
           {
        %>
               <a href="dogoods?pageIndex=<%=pageModel.getPageIndex()+1%>">[下一页]</a>&nbsp;
               <a href="dogoods?pageIndex=<%=pageModel.getPageTotal()%>">[尾页]</a>&nbsp;&nbsp;
         <%	   
           }
        %>
        
       </td>
     </tr>
     <tr height="50">
       <td align="center" colspan="3"><a href="shopcar.jsp">查看购物车</a></td>
     </tr>
  </table>
</body>
</html>