<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/secureheader.jsp"%>

<title>Car Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<div class='container'>
		<h3>Car Registration:</h3>
		<div class='container well col-md-8'>
			<form:form action="../addVehicle" method="post"
				class="form-horizontal" modelAttribute="vehicle">

				<input class="form-control" name="email" type="hidden" value=${email} >

				<div class="form-group">
					<label class="col-lg-3 control-label">Make:</label>
					<div class="col-lg-6">
						<form:input class="form-control" path="make" type="text" />
						<form:errors path="make" cssClass="error"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 control-label">Color:</label>
					<div class="col-lg-6">
						<form:input class="form-control" path="color" type="text" />
						<form:errors path="color" cssClass="error"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 control-label">Model:</label>
					<div class="col-lg-6">
						<form:input class="form-control" path="model" type="text" />
						<form:errors path="model" cssClass="error"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 control-label">Number Of Seats:</label>
					<div class="col-lg-6">
						<form:input class="form-control" type="text" path="numberOfSeats" />
						<form:errors path="numberOfSeats" cssClass="error"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 control-label">Type:</label>
					<div class="col-lg-6">
						<form:input class="form-control" type="text" path="type" />
						<form:errors path="type" cssClass="error"></form:errors>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-8">
						<input type="submit" class="btn btn-primary"
							value="Create Account">
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<%@include file="/WEB-INF/views/template/footer.jsp"%>