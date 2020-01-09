<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link href="userinputstyle.css" rel="stylesheet" type="text/css" />
</head>
<body >
<h1 style="text-align: center; margin: 10px"> RECHARGE  </h1>
<form  id="form2" method="get" action="processrecharge">
<div class="aaa">
<label> Phone Number </label>
<input class="bb" name="phone" type="text" align="center" placeholder = "Enter Phone Number" required/><br>
</div>
<div class="aaa">
<label> Amount </label>
<input class="bb" name="amount" type="number" align="center" placeholder="Enter amount" /><br>
</div>

<div class="aaa">
<button type="submit" align="center" value="Submit"/> Submit </button>
</div>


</form>
</body>
</html>