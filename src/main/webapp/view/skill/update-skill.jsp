<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update skill.</title>
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
    <h1>Update skill.</h1>
</div>
<br>
<form method="post" action="">
    ID = <%= request.getParameter("id")%> <br>
    <label><input type="text" name="name" value="<%= request.getParameter("name")%>" required></label>Name<br>

    <select name="level" required>
        <option value="Junior">Junior</option>
        <option value="Middle">Middle</option>
        <option value="Senior">Senior</option>
    </select>

    <input type="submit" value="Update" name="Update"><br>
</form>
</body>
</html>
