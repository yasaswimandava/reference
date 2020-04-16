<%@page import="com.mindtree.librarieswebapp.entity.Library"%>
<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displaying Book Details</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body  style="background-color: menu;" > 
	<div align="center">
		<h2>Book Details</h2>

		<hr />
		<br>
		<form:form>
			<table border="2" width=70% cellpadding="5">
				<tr>
					<th>Id</th>
					<th>Book Name</th>
					<th>Update</th>

				</tr>

				<c:forEach var="book" items="${booklist}">

					<tr align="center">
						<td>${book.bookId}</td>
						<td>${book.bookName}</td>


						<td><a href="editbook/${book.bookId}">Update</a></td>



					</tr>
				</c:forEach>
			</table>
		</form:form>
		<c:import url="/{libraryId}"></c:import>
		<br></br> <a href="bookadd?id=${libraryId}"><button type="button">Add
				New Book</button></a> &nbsp;&nbsp;&nbsp; 
				<a href="bookdelete?id=${libraryId}"><button
				type="button">Delete Book</button></a>
	</div>
</body>
</html>