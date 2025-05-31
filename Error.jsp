<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import = "java.io.PrintWriter"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>

<%-- declare variables that can be used
		throughout the page --%>
<%!
	Exception exception;
%>

<%-- retrieve the exception from the request
		attribute --%>
<%
	exception = (Exception) request.getAttribute( "exception" );
%>

<h1>Error Page</h1>

<h2>Error Message: <%= exception.getMessage() %></h2>

<pre>
<%-- print the stack trace to to web page --%>
<%
	exception.printStackTrace( new PrintWriter( out ) );
%>
</pre>

</body>
</html>