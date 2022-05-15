<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new customer</title>

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<security:authorize access="hasRole('USER')">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Add a new customer</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
					<form:form action="/saveCustomer" method="post"
						modelAttribute="customer">
						<form:hidden path="id" />
						
						<!-- First name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span>

							<form:input type="text" path="firstName" placeholder="firstname"
								autofocus="true" class="form-control" />
						</div>
												
						<!-- Last name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-pencil"></i></span>
							<form:input type="text" path="lastName" placeholder="lastname"
								class="form-control" />
						</div>

						<!-- Add button -->
						<div style="margin-top: 10px" class="form-group">
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-success">Add</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</security:authorize>
</body>
</html>


