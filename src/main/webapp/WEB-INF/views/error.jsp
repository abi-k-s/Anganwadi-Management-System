<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Error</title>
</head>
<body>
	<h2>Oops! Something went wrong.</h2>
	<p>
		Status code:
		<%=request.getAttribute("jakarta.servlet.error.status_code")%></p>
	<p>
		Message:
		<%=request.getAttribute("jakarta.servlet.error.message")%></p>
	<p>
		URI:
		<%=request.getAttribute("jakarta.servlet.error.request_uri")%></p>
</body>
</html>
