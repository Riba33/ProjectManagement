<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find project by name.</title>
    <style>
        .block1 {
            width: 200px;
            background: #ccc;
            padding: 10px 20px 10px 10px;
            border: solid 5px black;
        }
    </style>
</head>
<body>
<c:import url="/view/main-menu.jsp"/>
<div class="block1">
    <h1>Find project.</h1>
</div>
<br>
<form method="get" action="/my-app/project/find-project">
    <label><input type="text" name="name" required></label>Name<br>

    <input type="submit" value="Find" name="Find"><br>
</form>
</body>
</html>
