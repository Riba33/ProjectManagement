<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.Company" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>Show developers</title>
    <style>
        .block1 {
            width: 150px;
            background: #ccc;
            padding: 13px;
            padding-right: 20px;
            border: solid 5px black;
        }
    </style>
</head>
<body>
<c:import url="/main-menu.jsp"/>
<div class="block1">
    <h1>Developers</h1>
</div>
<br/>
<table border=5 cellpadding=5>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Salary</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="dev" items="${requestScope.developers}">
        <tr>
            <td>${dev.id}</td>
            <td>${dev.name}</td>
            <td>${dev.surname}</td>
            <td>${dev.age}</td>
            <td>${dev.gender}</td>
            <td>${dev.salary}</td>
            <td><a href="/my-app/update-developer?id=${dev.id}">Update</a></td>
            <td><a href="/my-app/delete-developer?id=${dev.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>