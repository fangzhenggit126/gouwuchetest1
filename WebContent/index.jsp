<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
     <form action="douser" method="get">
        <table border="1">
           <tr height="30">
             <td>用户名：</td>
             <td><input type="text" name="username" size="40"></td>
           </tr>
           <tr height="30">
             <td>密码：</td>
             <td><input type="password" name="password" size="40"></td>
           </tr>
           <tr height="30">
             <td colspan="2">
                <input type="submit" value="登陆">
                <a href="register.jsp">注册</a>
             </td>
           </tr>
        </table>
        <input type="hidden" name="action" value="login">
     </form>
  </center>
</body>
</html>