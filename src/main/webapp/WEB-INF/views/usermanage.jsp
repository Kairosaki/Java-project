<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1 align="center">Customer Database</h1>

   
	<form:form>
	<h3> Hello <i><security:authentication property="principal.username"/></i></h3>
	<h4>This is your current(s) role(s) : <i><security:authentication property="principal.authorities"/></i></h4>
			
		<!-- Customer list of the User for CRUD -->
		<table>
		<tr><th>Id</th><th>First Name</th><th>Last Name</th>
		<th>Edit</th><th>Delete</th></tr>
	
				<c:forEach var="customer" items="${customerList}">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
	
						<td><a href="${pageContext.request.contextPath}/editcustomer/${customer.id}">Edit</a></td>
						<td><a href="${pageContext.request.contextPath}/deletecustomer/${customer.id}">Delete</a></td>
					</tr>
				</c:forEach>
	
			</table>  
	   <br/>  
	   
	   	<!-- Add -->
	   	<div><a href="${pageContext.request.contextPath}/addcustomer">Add Customer</a></div>
		<br/>
		
		<!-- Clean -->
		<div><a href="${pageContext.request.contextPath}/delete">Clean All</a></div>
	   <br/> 
	   
	 </form:form>
	 
	 <!-- H2 Console for Admin only -->
	 <security:authorize access="hasRole('ADMIN')">
	 <form:form action="${pageContext.request.contextPath}/console" method="POST">
	 	<input type="submit" value="H2 console"/> Only only for ADMIN
	 </form:form>
	 </security:authorize>
	 
	 <!-- Logout -->
	 <form:form action="${pageContext.request.contextPath}/logout" method="POST">
	 	<input type="submit" value="Logout"/>
	 </form:form>
 
</body>
</html>