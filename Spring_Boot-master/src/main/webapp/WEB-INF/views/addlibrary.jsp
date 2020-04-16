<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Library</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body  style="background-color: menu;" > 
	<div align="center">
		<h2>Add New Library</h2>
		<!-- <hr style="width:50%" /> -->
		<hr />
		<br>
		<form:form  method="post" modelAttribute="library" action="savelibrary">
			<table>
				<tr>
					<td>Library Name :</td>
					<td><form:input path="libraryName" id="name" placeholder="Enter Library Name" required="required"/></td>
				</tr>


			</table>
			<br>
			<button type="submit" onclick="mySaveFunction()">Save</button>


		</form:form>

	</div>

	<script type="text/javascript">
	function mySaveFunction() {
		var inputVal = document.getElementById("name").value;
		console.log(inputVal);
		if (inputval=="Kiit") {
			alert("Book Added Sucessfully!");
			
		} 
		else
			alert("Failed");
	}
	</script>
</body>
</html>