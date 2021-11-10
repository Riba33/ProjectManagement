<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Update Project.</title>
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
  <h1>Update project.</h1>
</div>
<br>
<form method="get" action="/my-app/project/update-project">
  <label>ID<input type="text" readonly name="id" value="<%= request.getParameter("id")%>"></label><br>

  <label>Name<input type="text"  name="name" value="<%= request.getParameter("name")%>" required></label><br>

  <label>Date<input type="date" name="date" value="<%= request.getParameter("date")%>" required pattern="yyyy-MM-dd"></label><br>

  <input type="submit" value="Update" name="Update"><br>
</form>
</body>
</html>
