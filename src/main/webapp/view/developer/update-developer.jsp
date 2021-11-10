<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UpdateCustomer</title>
<style>
    .block1 {
        width: 235px;
        background: #ccc;
        padding: 10px 20px 10px 10px;
        border: solid 5px black;
    }
</style>
</head>
<body>
<c:import url="/view/main-menu.jsp"/>
<div class="block1">
    <h1>Update developer.</h1>
</div>
<br>
<form method="get" action="/my-app/developer/update-developer">
    <label>ID<input type="text" readonly name="id" value="<%= request.getParameter("id")%>"></label><br>
    <label>Name<input type="text" name="name" value="<%= request.getParameter("name")%>" required></label><br>
    <label>Surname<input type="text" name="surname" value="<%= request.getParameter("surname")%>" required></label><br>
    <label>Age<input type="digit" name="age" value="<%= request.getParameter("age")%>" required pattern="[0-9]{1,3}"></label><br>
    <label>Gender<input type="radio" name="gender" value="M" required>Man
        <input type="radio" name="gender" value="W">Woman
    </label><br>
    <label>Salary<input type="digit" name="salary" value="<%= request.getParameter("salary")%>" required pattern="[0-9]{1,6}"></label><br>
    <input type="submit" value="Update" name="Update"><br>
</form>
</body>
</html>
