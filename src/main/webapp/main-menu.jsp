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
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
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
    <a href="home.jsp">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Company
        <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/show-companies">Show Companies</a>
            <a href="/my-app/find-company">Find Company</a>
            <a href="/my-app/create-company">Create Company</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Customer
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/show-customers">Show Customers</a>
            <a href="/my-app/find-customer">Find Customer</a>
            <a href="/my-app/create-customer">Create Customer</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Developer
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/show-developers">Show Developers</a>
            <a href="/my-app/find-developer">Find Developer</a>
            <a href="/my-app/create-developer">Create Developer</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Project
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/show-projects">Show Project</a>
            <a href="/my-app/find-project">Find Project</a>
            <a href="/my-app/create-project">Create Project</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Skill
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/my-app/show-skills">Show Skills</a>
            <a href="/my-app/find-skills-by-name">Find Skill By Name</a>
            <a href="/my-app/find-skill-by-id">Find Skill By ID</a>
            <a href="/my-app/create-skill">Create Skill</a>
        </div>
    </div>
</div>
<br>



</body>
</html>
