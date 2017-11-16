<%@ page pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <style type="text/css">
	    body {font-size:24pt}
	    input {font-size:24pt}
    </style>
  </head>
  <body>
    <div>用户登陆</div>
    <form action="Login" method="post">
    user:<input type="text" name="name"/><br/>
    pass:<input type="password" name="pass"><br/>
    <input type="submit" value="提交" style="font-size:24pt"/>
    </form>
    <br/>
    <div style="color:red">${desc}</div>
  </body>
</html>
