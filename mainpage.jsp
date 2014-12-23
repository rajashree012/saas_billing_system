<%-- 
    Document   : index
    Created on : Feb 28, 2009, 9:45:01 AM
    Author     : Meyyappan Muthuraman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <s:head />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mainpage Page</title>
    </head>
    <body>
		<h1>Welcome!!</h1>
        <s:form action="Login1">
        <s:submit value="Login" />
	</s:form>
		<s:form action="Register">
        <s:submit value="Register" />
		</s:form>
		<s:form action="Services">
        <s:submit value="Services" />
        </s:form>
    </body>
</html>
