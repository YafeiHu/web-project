<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
  
  </head>  
    
  <body>  
      
    <h1 style="color: red;">sorry,you are not allowed to visit this information！</h1>  
    <a href=http://localhost:8081/coe/login>if you haven't login,login first!</a>
  </body>  
</html>  