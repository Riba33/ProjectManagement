<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create company</title>
    <style>
        .block1 {
            width: 230px;
            background: #ccc;
            padding: 10px;
            padding-right: 20px;
            border: solid 5px black;
        }
    </style>
</head>
<body>
<c:import url="/main-menu.jsp"/>
<div class="block1">
    <h1>Create company</h1>
</div>
<br>
<form method="post" action="">
    <label><input type="text" name="name" required></label>Name<br>

    <label><input type="text" name="safer" required></label>Safer<br>

    <input type="submit" value="Update" name="Update"><br>
</form>
</body>
</html>
