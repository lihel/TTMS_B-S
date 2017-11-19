<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.mypackage.ConnectionManager" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>
<body style="font-size:25pt">
<%

Connection con = ConnectionManager.getInstance().getConnection();
PreparedStatement pstmt = null;
ResultSet rs = null;
try
{
    // 获取所有用户数据
    pstmt = con.prepareStatement("select * from employee");
    rs = pstmt.executeQuery();
    String result;
    while (rs.next())
    {
        result = "";
        result += rs.getInt("emp_id") + " ";
        result += rs.getString("emp_no") + " ";
        result += rs.getString("emp_name") + " ";
        result += rs.getString("emp_tel_num") + " ";
        result += rs.getString("emp_addr") + " ";
        result += rs.getString("emp_email")+ "<br>";
        System.out.println(result);
    }
}
catch (Exception e)
{
    e.printStackTrace();
}
finally
{
    ConnectionManager.close(rs, pstmt, con);
}
%>
<h1>首页</h1>
</body>
</html>
