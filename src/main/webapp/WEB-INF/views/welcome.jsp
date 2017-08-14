<%@include file="/WEB-INF/views/template/secureheader.jsp"%>

<div class="container">

	<!-- Example row of columns -->
	<div class="">

		<h3>Welcome ${lastName} !!!</h3>

		<div class="row" style="padding-top: 20px;">
			<div class="col-md-offset-1 col-md-4 "
				style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px;">
				<h1>Car-Pooling</h1>
				<p>This is a template for a simple marketing or informational.</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Learn
						more &raquo;</a>
				</p>
			</div>

			<div class="col-md-offset-1 col-md-4 "
				style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px;">
				<h1>My-Rides</h1>
				<p>This is a template for a simple marketing or informational.</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Learn
						more &raquo;</a>
				</p>
			</div>
			
		</div>
		<div class="row" style="padding-top: 20px;">
			<div class="col-md-offset-1 col-md-4"
				style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px; margin-top: 20px;">
				<h2>List Of cars</h2>
				<table
					class="table table-striped, table table-hover table table-condensed table-bordered">
					<tr>

						<th>Vehicle Id</th>
						<th>Make</th>
						<th>Model</th>
						<th>No. of Seats</th>
						<th>Ride</th>

					</tr>
					<c:forEach var="vehicle" items="${vehicle}">

						<tr>
							<td>${vehicle.id}</td>
							<td>${vehicle.make}</td>
							<td>${vehicle.model}</td>
							<td>${vehicle.numberOfSeats}</td>
							<td><a href="ride/${ride.id}">rides</a></td>
					</c:forEach>
				</table>
			</div>
			<div class="col-md-offset-1 col-md-4"
				style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px; margin-top: 20px;">
				<h2>Subscribe for a ride</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in.</p>
				<p>
					<a class="btn btn-primary btn-default" href="#" role="button">View
						details &raquo;</a>
				</p>
			</div>
			<button type="submit" class="btn btn-default">UnSubscribe Your Ride</button>

		</div>
	</div>
	</div>


	<%@include file="/WEB-INF/views/template/footer.jsp"%>