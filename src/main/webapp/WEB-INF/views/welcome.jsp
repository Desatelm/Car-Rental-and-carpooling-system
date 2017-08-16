<%@include file="/WEB-INF/views/template/secureheader.jsp"%>

<div class="container">

	<!-- Example row of columns -->
	<div class="">

		<h3>Welcome ${lastName} !!!</h3>
          
		<div class="row" style="padding-top: 20px;">
		    <div class=" col-md-4">
			<div style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px;">
				<h1>Car-Pooling</h1>
				<p>This is a template for a simple marketing or informational.</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Learn
						more &raquo;</a>
				</p>
			</div>
            
            <div style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px; margin-top: 20px;">
				<h2>List Of cars</h2>
				<table
					class="table table-striped, table table-hover table table-condensed table-bordered">
					<tr>

					<th>Vehicle Id</th>
					<th>Make</th>
					<th>Model</th>
					<th>No. of Seats</th>
					<th>Ride</th>
					<th>Action</th>

					</tr>
					<c:forEach var="vehicle" items="${vehicle}">
						<tr>
							<td>${vehicle.id}</td>
							<td>${vehicle.make}</td>
							<td>${vehicle.model}</td>
							<td>${vehicle.numberOfSeats}</td>
							<td><a href="ride/${ride.id}">rides</a></td>
							<td><form action="/deleteVehicle/${vehicle.id}" method="post">
										<input class="form-control" name = "email" type="hidden" value = "${email}">
										<input type="submit" value="delete">
									</form></td>
					</c:forEach>
				</table>
			</div>  
			
			<div  style="background: rgba(0, 0, 0, 0.3);  border-radius: 5px; margin-top: 20px;">
				<h2>POST OFFERS</h2>
				<form method="post" action="ride/registed">
				<fieldset>
					<div class="form-row">
						<div>
							Departure : <input class="placepicker form-control" type="text"
								id="departure" name="departure" placeholder="Departure location" />

						</div>
						<div>
							Destination: <input type="text" class="placepicker form-control"
								id="destination" name="destination"
								placeholder="Destination location" />

						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								Departure Date : <input class="form-control"
									name="registration_date" id="registration-date"
									name="departureDate" type="date" />
							</div>
							<div class="form-group col-md-6">
								Departure Time : <input class="form-control"
									id="registration-time" name="departureTime" type="time" />
							</div>
						</div>
						<div>

							vehicle:<select name="model" class="form-control">
								<c:forEach var="car" items="${userVehicle }">
									<option value="${car.id }">${car.make},${car.model},
										${car.type}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								Number of Seats: <input type="number" class="form-control"
									name="noSeat" />
							</div>
							<div class="form-group col-md-6">
								Price: <input type="number" class="form-control" name="price" />
							</div>
						</div>

						<div>
							Waiting Time <input class="form-control" name="waitingTime" />
						</div>
						<div>
							<input class="form-control" name="email" type="hidden"
								value=${email} >
						</div>

						<button type="submit" class="btn btn-secondary btn-lg">POST</button>
					</div>
				</fieldset>
			</form>
			</div>
		    </div>
		<div class="col-md-offset-1 col-md-6" >
            <div style="background: rgba(0, 0, 0, 0.3);  border-radius: 5px; margin-top: 20px; margin-left: 20px;">
				<h1>List of Offered Rides.....</h1>
				
				<c:forEach var="post" items="${allRides}">
				<div style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px; margin-top: 20px;">
					<div class="row">
						<ul>
							<li>
								<p>Departure : ${post.departure}</p>
								<p>Destination : ${post.destination}</p>
								<p>price : ${post.price}USD Available Seat:</p>
								<P>Status : ${post.status}</P>
								<p>Vehicle :</p>
								<P>Posted By : ${post.offeredBy}</P>
							</li>
						</ul>
						<div>													
							<form method="post" action="feedback/comment">
								<input class="form-control input-sm" type ="search" name="comment"
									placeholder="write comment here ...."></input>								
									<input class="form-control" name="email" type="hidden"
										value="${email}" >								
									<input class="form-control" name="id" type="hidden"
										value="${post.id}">	
								<a class="pull-right btn btn-primary btn-default"
								href="/ride/apply/${post.id}" role="button">Apply</a>
							</form>
							
						</div>
						<div>
							<c:forEach var="com" items="${post.feedbacks}">
								<div>
									<p>
										<c:set var="x" value="${id}">
										</c:set>
										<c:set var="y" value="${com.user.id}">
										</c:set>
										${com.user.name}| ${com.comment}
										<div class= "pull-right">
									<form action="feedback/comment/delete/${com.id}" method="post">
										<c:if test="${x == y }">
											<button type="submit" class="btn btn-danger"
												class="btn btn-primary btn-sm">Delete</button>
											
										</c:if>
									</form>
									</div>
									</div>
                              </c:forEach>
									
								</div>
						<hr>
					</div>
					</div>
				</c:forEach>
			</div>			
	    </div>	
		</div>
		
           
	</div>
	<div class="container pull-left">
	
	</div>
	</div>


	<%@include file="/WEB-INF/views/template/footer.jsp"%>