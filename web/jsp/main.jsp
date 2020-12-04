<%--
  Created by IntelliJ IDEA.
  User: SUPERME
  Date: 2020/12/4
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
    <title>自动刷新页面</title>
</head>
<body>
<h2>自动刷新实例</h2>
<%
    //设置每隔5秒刷新一次
    response.setIntHeader("Refresh",5);
    //获取当前时间
    Calendar calendar = new GregorianCalendar();
    String am_pm;
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    if(calendar.get(Calendar.AM_PM) == 0)
        am_pm = "AM";
    else
        am_pm = "PM";
    String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
    out.println("当前时间为: " + CT + "\n");
%>
</body>
</html>
