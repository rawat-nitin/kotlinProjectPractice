<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    List<String> CampusesList = new ArrayList<>();
    CampusesList.add("Hyakuman-Ben");
    CampusesList.add("Kyoto-Eki Mae");
    CampusesList.add("Tokyo");
    CampusesList.add("Sapporo");
    request.setAttribute("CampusesList", CampusesList);
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Campuses1</title>
</head>
<body>
<h1><%= "Campuses1 Showing List" %>
</h1>
<ul>
    <c:forEach items="${CampusesList}" var="value">
        <li><c:out value="${value}"/></li>
    </c:forEach>
</ul>
</body>
</html>