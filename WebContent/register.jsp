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
    <form action="douser" method="post">
       <table border="1">
           <tr height="30">
             <td>登录名：</td>
             <td><input type="text" name="username" size="40"></td>
           </tr>
           <tr height="30">
             <td>中文名：</td>
             <td><input type="text" name="cname" size="40"></td>
           </tr>
           <tr height="30">
             <td>密码：</td>
             <td><input type="password" name="password" size="40"></td>
           </tr>
           <tr height="30">
             <td>性别：</td>
             <td><input type="text" name="sex" size="40"></td>
           </tr>
           <tr height="30">
             <td>年龄：</td>
             <td><input type="text" name="age" size="40"></td>
           </tr>
           <tr height="30">
             <td>住址：</td>
             <td><input type="text" name="address" size="40"></td>
           </tr>
           <tr height="30">
             <td colspan="2">
                <input type="submit" value="注册">
                <input type="reset" value="重置">
             </td>
           </tr>
        </table>
         <input type="hidden" name="action" value="register">
      </form>
  </center>
</body>
</html>