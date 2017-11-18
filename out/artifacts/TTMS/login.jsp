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
    <link rel="stylesheet" href="view/CSS/bs.css">
    <link rel="stylesheet" href="view/CSS/index.css">
    <%--<style type="text/css">
	    body {font-size:24pt}
	    input {font-size:24pt}
    </style>--%>
  </head>
  <body>
   <%-- <div>用户登陆</div>
    <form action="Login" method="post">
    user:<input type="text" name="name"/><br/>
    pass:<input type="password" name="pass"><br/>
    <input type="submit" value="提交" style="font-size:24pt"/>
    </form>--%>
    <div class="container">
      <div class="panel panel-primary sign">

        <h3 class="text-center">欢迎登陆TTMS</h3>

        <form action="Login" method="post">

          <div class="text-center">
            用户名：<input type="text" name="name" required="required"/>
          </div>

          <div class="text-center pass">
            密　码：<input type="password" name="pass" required="required"/>
          </div>
          <div class="text-center signbutt">
            <button type="submit" class="btn btn-primary btn-block">登陆</button>
          </div>
        </form>

      </div>
      <br/>
      <div style="color:red">${desc}</div>
    </div>
  </body>
</html>
