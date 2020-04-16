<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
<body style="background-color: menu;">
	<div align="center">
		<h2>Add New Book</h2>
		<!-- <hr style="width:50%" /> -->
		<hr />
		<br>

		<form:form method="post" modelAttribute="book"
			action="savebook?id=${lib.libraryId}">

			<table>
				<tr>
					<td>Book Name :</td>
					<td><form:input path="bookName" id="name" placeholder="Enter Book Name" required="required" /></td>
				</tr>


			</table>
			<br>
			<button type="submit" onclick="mySaveFunction()">Save</button>


		</form:form>

	</div>

	<script type="text/javascript">
		function mySaveFunction() {
			var inputVal = document.getElementById("name").value;
			if (inputval.trim() != "") {
				alert("Book Added Sucessfully!");
			} else {

			}
		}
	</script>
</body>
</html>