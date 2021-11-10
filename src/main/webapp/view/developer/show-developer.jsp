<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
<c:import url="/view/main-menu.jsp"/>
<div class="block1">
    <h1>Developers</h1>
</div>
<br/>
<table border=5 cellpadding=5>
    <tr>
        <th>ID</th>
        <th>UserName</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Salary</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:set var="dev" value="${requestScope.developer}"/>
        <tr>
            <td>${dev.id}</td>
            <td>${dev.username}</td>
            <td>${dev.name}</td>
            <td>${dev.surname}</td>
            <td>${dev.age}</td>
            <td>${dev.gender}</td>
            <td>${dev.salary}</td>
            <td><a href="/my-app/view/developer/update-developer.jsp?id=${dev.id}&username=${dev.username}&name=${dev.name}
                        &surname=${dev.surname}&age=${dev.age}&gender=${dev.gender}&salary=${dev.salary}">Update</a></td>
            <td><a href="/my-app/developer/delete-developer?id=${dev.id}">Delete</a></td>
        </tr>
</table>
</body>
</html>