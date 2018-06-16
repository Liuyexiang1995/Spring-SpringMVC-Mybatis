<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<p>Hello web!</p>
	<p>
		<%  Date date=new Date();  %>
		服务器时间：<fmt:formatDate value="<%=date %>" pattern="yyyy-MM-dd HH:mm:ss"/>
	</p>
</body>
</html>