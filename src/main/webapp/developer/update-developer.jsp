<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UpdateCustomer</title>
<style>
    .block1 {
        width: 235px;
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
    <h1>Update customer</h1>
</div>
<br>
<form method="post" action="">
    ID = <%= request.getParameter("id")%> <br>
    <label>Name<input type="text" name="name" required></label><br>
    <label>Surname<input type="text" name="surname" required></label><br>
    <label>Age<input type="digit" name="age" required pattern="[0-9]{1,3}"></label><br>
    <label>Gender<input type="radio" name="gender" value="M">Man
        <input type="radio" name="gender" value="W">Woman
    </label><br>
    <label>Salary<input type="digit" name="salary" required pattern="[0-9]{1,6}"></label><br>
    <input type="submit" value="Update" name="Update"><br>
</form>
</body>
</html>
