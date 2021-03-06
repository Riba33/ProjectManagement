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
    <h1>Customers</h1>
</div>
<br/>
<table border=5 cellpadding=5>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Safer</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="cust" items="${requestScope.customers}">
        <tr>
            <td>${cust.id}</td>
            <td>${cust.name}</td>
            <td>${cust.safer}</td>
            <td><a href="/my-app/view/customer/update-customer.jsp?id=${cust.id}&name=${cust.name}&safer=${cust.safer}">Update</a></td>
            <td><a href="/my-app/customer/delete-customer?id=${cust.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>