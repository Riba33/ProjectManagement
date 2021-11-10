<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .navbar {
            overflow: hidden;
            background-color: #333;
            font-family: Arial, Helvetica, sans-serif;
        }

        .navbar a {
            float: left;
            font-size: 16px;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .dropdown {
            float: left;
            overflow: hidden;
        }

        .dropdown .dropbtn {
            font-size: 16px;
            border: none;
            outline: none;
            color: white;
            padding: 14px 16px;
            background-color: inherit;
            font-family: inherit;
            margin: 0;
        }

        .navbar a:hover, .dropdown:hover .dropbtn {
            background-color: red;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .dropdown-content a {
            float: none;
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {
            background-color: #ddd;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
    <title>Main menu</title>
</head>
<body>
<div class="navbar">
    <a href="/my-app/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Company
        <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/company/show-companies">Show Companies</a>
            <a href="/my-app/view/company/find-companies-by-name.jsp">Find Companies By Name</a>
            <a href="/my-app/view/company/create-company.jsp">Create Company</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Customer
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/customer/show-customers">Show Customers</a>
            <a href="/my-app/view/customer/find-customers-by-name.jsp">Find Customers By Name</a>
            <a href="/my-app/view/customer/create-customer.jsp">Create Customer</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Developer
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/developer/show-developer">Show Developers</a>
            <a href="/my-app/view/developer/find-developers-by-name.jsp">Find Developers By Name</a>
            <a href="/my-app/view/developer/find-developer-by-username.jsp">Find Developer By UserName</a>
            <a href="/my-app/view/developer/create-developer.jsp">Create Developer</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Project
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/project/show-project">Show Project</a>
            <a href="/my-app/view/project/find-projects-by-name.jsp">Find Projects By Name</a>
            <a href="/my-app/view/project/create-project.jsp">Create Project</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Skill
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/skill/show-skill">Show Skills</a>
            <a href="/my-app/view/skill/find-skills-by-name.jsp">Find Skills By Name</a>
            <a href="/my-app/view/skill/find-skill-by-id.jsp">Find Skill By ID</a>
            <a href="/my-app/view/skill/create-skill.jsp">Create Skill</a>
        </div>
    </div>
</div>
<br>



</body>
</html>
