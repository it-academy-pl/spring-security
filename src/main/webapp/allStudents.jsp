<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%@ page import="pl.itacademy.model.Student" %>
<%@ page import="java.util.List" %>

<html>
<body>
<h1>List of students</h1>
<ul>

<% List<Student> students= (List)request.getAttribute("students"); %>
<c:forEach items="${students}" var="student"  >
        <li>${student.name} ${student.surname} ${student.email}</li>
</c:forEach>

<ul>
</body>
</html>