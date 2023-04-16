<%@page import="in.ineuron.dto.IssueDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.Date"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Return Book Status</title>
<link rel="stylesheet" href="../student_style.css">
    <style>
        .operations{
            position: absolute;
        }
        .operations{
            padding-left:350px;
            
        }
        .operations select{
            height: 35px;
            width:200px;
        }
        .btn{
            border: 2px solid grey;
            border-radius: 29px;
            margin: 7px auto;
            width: 86px;
            font-size: 15px;
            padding: 10px;
            background: none;
            font-family: 'Ubuntu', sans-serif;
            outline: none;

        }
        .btn:hover{
            cursor: pointer;
            background-color: burlywood;
        }
    </style>
</head>
<body>
	<header>  
        <div class="logo"><img src="../logo.png"></div>   
        <div class="text"><h1> E-Library </h1></div>  
        <div class="dummies">
            <ul>
                <li><a href="../studentLogin.html">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
    </header>
	<c:choose>
		<c:when test="${issuedto ne null || ! empty issuedto}">
			<h1 style="color:green;text-align:center">Book Returned Successfully </h1>						
		</c:when>
		<c:otherwise>
			<h1 style="color:red;text-align:center">Book Return Unsuccessfull</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>