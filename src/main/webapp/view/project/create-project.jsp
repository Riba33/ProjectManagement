<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create project.</title>
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
    <h1>Create project.</h1>
</div>
<br>
<form method="post" action="/my-app/project">
    <label>Name<input type="text" name="name" required></label><br>

    <label>Date<input type="date" name="date" required pattern="yyyy-MM-dd" min="1975-01-01" max="2050-12-31"></label><br>

    <input type="submit" value="Create" name="Create"><br>
</form>
</body>
</html>
