<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.Company" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>Show customers</title>
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
<c:import url="/view/main-menu.jsp"/>
<div class="block1">
    <h1>Skills</h1>
</div>
<br/>
<table border=5 cellpadding=5>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Level</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="skill" items="${requestScope.skills}">
        <tr>
            <td>${skill.id}</td>
            <td>${skill.name}</td>
            <td>${skill.level}</td>
            <td><a href="/my-app/update-skill?id=${skill.id}&name=${skill.name}">Update</a></td>
            <td><a href="/my-app/delete-skill?id=${skill.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>