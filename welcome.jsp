<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ww" uri="/webwork" %>
<jsp:include page="loginCheck.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>

<body>Welcome, you have logined. <br />
The attribute of 'context' in session is
<ww:property value="#session.context" />
<br /><br /><br />
<a xhref="<%= request.getContextPath() %>/logout.action">Logout</a>
<br />
<a xhref="<%= request.getContextPath() %>/logout2.action">Logout2</a>
</body>
</html>