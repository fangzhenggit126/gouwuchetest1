<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
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
     <c:if test="${goodslist==null}">
        <tr height="100">
          <td colspan="3" align="center">没有商品可显示！</td>
        </tr>
    </c:if>
     <c:forEach items="${goodslist}" var="goods">
        <tr height="50" align="center">
		      <td>${goods.name}</td>
		     <td>${goods.price}</td>
		     <td><a href="docar?action=buy&no=${goods.no}">购买</a></td>
	    </tr>
    </c:forEach>
     <tr height="50">
       <td align="center" colspan="3">
         <c:if test="${pageModel.pageIndex==1}">
              [首页]&nbsp;[上一页]&nbsp;&nbsp;
         </c:if>
         <c:if test="${pageModel.pageIndex>1}">
              <a href="dogoods?pageIndex=1">[首页]</a>&nbsp;
              <a href="dogoods?pageIndex=${pageModel.pageIndex-1}">[上一页]</a>&nbsp;&nbsp;
         </c:if>
         <c:if test="${pageModel.pageIndex==pageModel.pageTotal}"> 
               [下一页]&nbsp;[尾页]&nbsp;&nbsp;
         </c:if>
         <c:if test="${pageModel.pageIndex<pageModel.pageTotal}"> 
               <a href="dogoods?pageIndex=${pageModel.pageIndex+1}">[下一页]</a>&nbsp;
               <a href="dogoods?pageIndex=${pageModel.pageIndex=pageModel.pageTotal}">[尾页]</a>&nbsp;&nbsp;
         </c:if>
        
       </td>
     </tr>
     <tr height="50">
       <td align="center" colspan="3"><a href="shopcar.jsp">查看购物车</a></td>
     </tr>
  </table>
</body>
</html>