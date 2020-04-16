<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">

</head>
<body>
	<div align="center">
		<form:form  method="post" modelAttribute="loginobj" action="verify">
		<h2><b>Account Login</b></h2>
		<hr>
			<table>
			
				<tr>
					<td><b>Username :</b></td>
					<td><form:input path="username" placeholder="Enter Username"
							required="required" /></td>
				</tr>
					
				<tr>
					<td><b>Password :</b></td>
					<td><form:password path="password" placeholder="Enter Password"
							required="required" /></td>
				</tr>

			</table>
			<br>
			 <a href="/indexpage"><button type="submit">
				<b>Login</b>
			</button></a>
		</form:form>
	</div>
</body>
</html>