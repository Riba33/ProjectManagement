<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find developer by name!</title>
    <style>
        .block1 {
            width: 210px;
            background: #ccc;
            padding: 10px 20px 10px 10px;
            border: solid 5px black;
        }
    </style>
</head>
<body>
<c:import url="/view/main-menu.jsp"/>
<div class="block1">
    <h1>Find developer by username.</h1>
</div>
<br>
<form method="get" action="/my-app/developer/find-developer-by-username">
    <label><input type="text" name="username" required></label>UserName<br>
    <input type="submit" value="Find" name="Find"><br>
</form>
</body>
</html>
