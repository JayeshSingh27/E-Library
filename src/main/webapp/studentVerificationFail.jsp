<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1 style="text-align:center;color:red">Invalid Credentials</h1>
</body>
</html>