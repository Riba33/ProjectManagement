<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create skill.</title>
    <style>
        .block1 {
            width: 230px;
            background: #ccc;
            padding: 10px 20px 10px 10px;
            border: solid 5px black;
        }
    </style>
</head>
<body>
<c:import url="/view/main-menu.jsp"/>
<div class="block1">
    <h1>Create skill.</h1>
</div>
<br>
<form method="post" action="/my-app/skill">
    <label><input type="text" name="name" required></label>Name<br>
    <select name="level" required>
        <option value="Junior">Junior</option>
        <option value="Middle">Middle</option>
        <option value="Senior">Senior</option>
    </select>

    <input type="submit" value="Create" name="Create"><br>
</form>
</body>
</html>
