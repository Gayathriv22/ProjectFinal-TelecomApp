<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="userinputstyle.css" rel="stylesheet" type="text/css" />
</head>
<body >
<h1 style="text-align: center; margin: 10px"> LOGIN </h1>
<form  id="form2" method="get" action="logincheck">
<div class="aaa">
<label> Phone Number </label>
<input class="bb" name="phone" type="text" align="center" placeholder = "Enter Phone Number" required/><br>
</div>
<div class="aaa">
<label> Password </label>
<input class="bb" name="password" type="password" align="center" placeholder="Enter Password" /><br>
</div>

<div class="aaa">
<button type="submit" align="center" value="Submit"/> Login </button>
</div>


</form>
</body>
</html>