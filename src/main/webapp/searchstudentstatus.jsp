<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		<c:when test="${student ne null || !empty student}">
			<table border="1px" text-align="center">
				<tr>
					<td>Student ID </td>
					<td>Student Name </td>
					<td>Student Department</td>
					<td>Student Year </td>
					<td>Student Course </td>
					<td>Student Phone no </td>
					<td>Student Email-ID </td>
				</tr>
				<tr>
					<td>${student.studentId}</td>
					<td>${student.studentName}</td>
					<td>${student.studentDepartment}</td>
					<td>${student.studentYear }</td>
					<td>${student.studentCourse }</td>
					<td>${student.studentPhoneno }</td>
					<td>${student.studentEmail }</td>
				</tr>
			</table>			
		</c:when>
		<c:otherwise>
			<h1 style="color:red;text-align:center"> No Record Available </h1>
		</c:otherwise>
	</c:choose>
</body>
</html>