<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
 <link href="registerstyle.css" rel="stylesheet" type="text/css" />
 </head>
<body >
<h1 style="text-align: center; margin: 10px"> REGISTRATION FORM </h1>
<form id="form1" method="get" action="processregister" style="text-align: center; margin: 10px">

<div  class = "aaa">
<label> Phone Number</label>
<input name="phone" type="text"  align="center" placeholder = "Enter Phone Number" />
  </div>
  <div  class = "aaa">
<label>Account Name </label>
<input name="name" type="text"  align="center" placeholder="Enter Name"/>
</div>
<div class = "aaa">
<label> Account Type </label>
<input name="acctype" type="text" align="center" placeholder="Prepaid/Postpaid"/>
</div>
<div class = "aaa">
<label> Password </label>
<input name="password" type="password"  align="center" placeholder="Enter Password" />
</div>
<div class = "aaa">
<button type="submit"  align="center" value="Submit"> Register </button>
</div>

</form>
</body>
</html>