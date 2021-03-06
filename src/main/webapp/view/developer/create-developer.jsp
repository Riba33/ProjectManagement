<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create developer</title>
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
    <h1>Create developer</h1>
</div>
<br>
<form method="post" action="/my-app/developer">
    <label>Name<input type="text" name="name" required></label><br>
    <label>Surname<input type="text" name="surname" required></label><br>
    <label>Age<input type="digit" name="age" required pattern="[0-9]{1,3}"></label><br>
    <label>Gender<input type="radio" name="gender" value="M">Man
                 <input type="radio" name="gender" value="W">Woman
    </label><br>
    <label>Salary<input type="digit" name="salary" required pattern="[0-9]{1,6}"></label><br>
    <input type="submit" value="Create" name="Create"><br>
</form>
</body>
</html>
