<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UpdateCompany</title>
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
    <h1>Update company</h1>
</div>
<br>
<form method="get" action="/my-app/company/update-company">

    <label>ID<input type="text" readonly name="id" value="<%= request.getParameter("id")%>"></label><br>

    <label>Name<input type="text" name="name" value="<%= request.getParameter("name")%>" required></label><br>

    <label>Safer<input type="text" name="safer" value="<%= request.getParameter("safer")%>" required></label>Safer<br>

    <input type="submit" value="Update" name="Update"><br>
</form>
</body>
</html>
