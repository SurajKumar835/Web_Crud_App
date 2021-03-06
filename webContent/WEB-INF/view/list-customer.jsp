<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2> CRM-Customer Relationship Manager</h2>
	</div>
</div>
<div id="container">
<div id="content">
	<input type="button" value="Add Customer" 
	onclick="window.location.href='addform';return false;" class ="add-button"/>
	  <!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
</div>
<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Update Info</th>
		<th>Delete Info</th>
	</tr>
	<c:forEach var="temp" items="${customers}">
	<c:url var="updateLink" value="/customer/showformforupdate">	
	<c:param name="customerId" value="${temp.id}"></c:param>
	</c:url>
	<c:url var="deleteLink" value="/customer/delete">
	<c:param name="customerId" value="${temp.id}"></c:param>
	</c:url>
		<tr>
			<td>${temp.firstName}</td>
			<td>${temp.lastName}</td>
			<td>${temp.email}</td>
			<td><a href="${updateLink}">Update</a></td>
			<td><a href="${deleteLink}" onclick="if(!(confirm('Are you sure want to delete it?'))) return false">delete</a></td>
		</tr>
	</c:forEach>
</table>
 </div>

</body>
</html>