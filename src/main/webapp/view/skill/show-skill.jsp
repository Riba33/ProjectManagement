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
            padding: 13px 20px 13px 13px;
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
    <c:set var="skill" value="${requestScope.skill}"/>
        <tr>
            <td>${skill.id}</td>
            <td>${skill.name}</td>
            <td>${skill.level}</td>
            <td><a href="/my-app/view/skill/update-skill.jsp?id=${skill.id}&name=${skill.name}&skill=${skill.level}">Update</a></td>
            <td><a href="/my-app/skill/delete-skill?id=${skill.id}">Delete</a></td>
        </tr>
   </table>
</body>
</html>