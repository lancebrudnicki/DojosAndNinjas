<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
	<form:form action="/ninja/new" method="post" modelAttribute="ninja">
		<form:errors path="*" />
		<p>
			First Name:
			<form:errors path="firstname" />
			<form:input path="firstname" />
		</p>
		<p>
			Last Name:
			<form:errors path="lastname" />
			<form:input path="lastname" />
		</p>
		<p>
			Age:
			<form:errors path="age" />
			<form:input type="number" path="age" />
		</p>


	<p>
		<form:label path="dojo" >select your dojo </form:label>
		<form:errors path="dojo"/>
		<form:select path="dojo">
			<option value="" disabled selected>
			<c:forEach items="${dojos}" var="dojo">
				<form:option value="${dojo.id}">
					${dojo.name}
				</form:option>
			</c:forEach>
		</form:select>
	</p>
		<input type="submit" value="create" />
	</form:form>
	
</body>
</html>