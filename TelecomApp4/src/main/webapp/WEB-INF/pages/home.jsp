<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="homestyle.css" rel="stylesheet" type ="text/css">
</head>
<body class="homebody" style="max-width:1300px; ">
<div class="c1">


            <h2>
                Hello <c:out value="${user.name}"/>!!!<br>
            </h2>
            <img src="person.png" alt="Person" style="width:20%; height: 20%">
        <h1>DETAILS</h1>

       <h4>
       Id: <c:out value="${user.id}"/>. <br>
       Phone Number:  <c:out value="${user.phoneNo}"/>. <br>
       Name: <c:out value="${user.name}"/>.<br>
       Account type: <c:out value="${user.accType}"/>.<br>
       Balance: <c:out value="${user.balance}"/>.<br>
       </h4>




<button class="btn"> <a href="/recharge"> RECHARGE ACCOUNT </a></button>
</div>


<button class="btn"> <a href="/signout"> SIGN OUT </a></button>

</body>
</html>