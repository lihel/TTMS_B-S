<%@ page pageEncoding="UTF-8" isErrorPage="false" errorPage="error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String flag=(String)session.getAttribute("login");
if(flag==null || !flag.equals("ok"))
{
    request.getSession().setAttribute("desc", "请从入口登陆。");
    request.getRequestDispatcher("login.jsp").forward(request, response);
}
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
欢迎，${name} ! <br>
a目录：<br>
<a href="./WEB-INF/a/a1.jsp">a/a1.jsp</a><br>
<a href="./WEB-INF/a/a2.jsp">a/a2.jsp</a><br>
b目录：<br>
<a href="./WEB-INF/b/b1.jsp">b/b1.jsp</a><br>
<a href="./WEB-INF/b/b2.jsp">b/b2.jsp</a><br>
</body>
</html>