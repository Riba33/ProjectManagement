<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.Company" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <title>Show projects.</title>
    <style>
        .block1 {
            width: 150px;
            background: #ccc;
            padding: 13px 20px 13px 13px;
            border: solid 5px black;
        }
    </style>
</head>
<body>
<c:import url="/view/main-menu.jsp"/>
<div class="block1">
    <h1>Projects.</h1>
</div>
<br/>
<table border=5 cellpadding=5>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Date</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="project" items="${requestScope.projects}">
        <tr>
            <td>${project.id}</td>
            <td>${project.name}</td>
            <td><fmt:formatDate value="${project.date}" pattern="dd-MM-yyyy"/> </td>
            <td><a href="/my-app/update-project?id=${project.id}&name=${project.name}">Update</a></td>
            <td><a href="/my-app/delete-project?id=${project.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>