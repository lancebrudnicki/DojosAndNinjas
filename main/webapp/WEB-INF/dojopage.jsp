<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
</head>
<body>
	<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<!-- this is our for loop to display the songs in our table -->
			<c:forEach items="${dojo.ninja}" var="ninja">
				<tr>
					<td><c:out value="${ninja.firstname}"/></td>
					<td><c:out value="${ninja.lastname}"/></td>
					<td><c:out value="${ninja.age}"/></td>
				</tr>
			</c:forEach>
			<!-- end the loop  -->
		</tbody>	
	</table>
</body>
</html>