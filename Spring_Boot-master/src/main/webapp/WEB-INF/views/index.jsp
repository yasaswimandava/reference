<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displaying Libraries</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body  style="background-color: menu;" > 

	<div align="center">
		<h2>Library Management</h2>
		<hr />
		<br>
		<form:form>
			<table border="2" width=70% cellpadding="5">
				<tr>
					<th>Id</th>
					<th>Library Name</th>
					<th>Update</th>
					<th>Details</th>
				</tr>

				<c:forEach var="library" items="${librarylist}">

					<tr align="center">
						<td>${library.libraryId}</td>
						<td>${library.libraryName}</td>


						<td><a href="editlibrary/${library.libraryId}">Update</a></td>
						<td><a href="${library.libraryId}">Details</a></td>


					</tr>
				</c:forEach>
			</table>
		</form:form>
		<br></br>
		 <a href="/addnewlibrary"><button type="button">Add New Library</button></a> 
		 &nbsp;&nbsp;&nbsp; 
		 <a href="/librarydelete" ><button type="button">Delete Library</button></a>
	</div>

	
</body>
</html>