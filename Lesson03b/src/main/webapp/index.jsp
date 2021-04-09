<%@ page import="edu.kcg.web3.lesson03b.Person" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Go to Hello page</a><br>
<a href="other">Go to Other page</a><br>
<%=
"Your IP address is " + request.getRemoteAddr()
%>
<br>
<%=
new Person().loadData().getName()
%>
</body>
</html>