<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/secureheader.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<form:form method="post" action="../registration"
				modelAttribute="ride">
				<fieldset>
					<div class="form-row">
						<div>
							Departure :(*)
							<form:input class="placepicker form-control" type="text"
								id="departure" path="departure" placeholder="Departure location" />
							<form:errors path="departure" cssClass="error"></form:errors>

						</div>
						<div>
							Destination :(*)
							<form:input type="text" class="placepicker form-control"
								id="destination" path="destination"
								placeholder="Destination location" />
							<form:errors path="destination" cssClass="error"></form:errors>

						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								Departure Date :(*)
								<form:input class="form-control" id="registration-date"
									path="departureDate" type="date" />
								<form:errors path="departureDate" cssClass="error"></form:errors>
							</div>
							<div class="form-group col-md-6">
								Departure Time :(*)
								<form:input class="form-control" id="registration-time"
									path="departureTime" type="time" />
								<form:errors path="departureTime" cssClass="error"></form:errors>
							</div>
						</div>
						<div>
							vehicle :(*)
							<form:select path="model" class="form-control" id="cars">
								<c:forEach var="car" items="${userVehicle }">
									<form:option value="${car.id }"
										data-seats="${car.numberOfSeats}">${car.make},${car.model},
										${car.type}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="model" cssClass="error"></form:errors>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								Number of Seats :(*)
								<form:select class="form-control" path="noSeat" id="noOfSeats"></form:select>
								<form:errors path="noSeat" cssClass="error"></form:errors>
							</div>
							<div class="form-group col-md-6">
								Price :(*)
								<form:input type="number" class="form-control" path="price" />
								<form:errors path="price" cssClass="error"></form:errors>
							</div>
						</div>

						<div>
							Waiting Time :(*)
							<form:select path="waitingTime" class="form-control" id="cars">
								<form:option value="10">10 minutes</form:option>
								<form:option value="10">20 minutes</form:option>
								<form:option value="10">30 minutes</form:option>
							</form:select>
							<form:errors path="waitingTime" cssClass="error"></form:errors>
						</div>
						<div>
							<input class="form-control" name="email" type="hidden"
								value=${email} >
						</div>

						<button type="submit" class="btn btn-secondary btn-lg">POST</button>

					</div>
				</fieldset>
			</form:form>
		</div>
		<div class="col-sm-8">
			<div>
				<c:forEach var="post" items="${allRides}">
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
							<a class="btn btn-primary btn-default"
								href="/ride/apply/${post.id}" role="button">Apply</a>
						</div>
						<div>
							<c:forEach var="com" items="${post.feedbacks}">
								<div>
									<p>
										<c:set var="x" value="${id}">
										</c:set>
										<c:set var="y" value="${com.user.id}">
										</c:set>
										${com.comment}
									<form action="../comment/delete/${com.id}" method="post">
										<c:if test="${x == y }">

											<button type="submit" class="btn btn-danger"
												class="btn btn-primary btn-sm">Delete</button>
											<%-- <a class="btn btn-danger" href="../comment/delete/${com.id}">
												<i class="icon-trash icon-white"></i> Delete
											</a> --%>
										</c:if>
									</form>

									
								</div>
							</c:forEach>
							<form method="post" action="../comment">
								<textarea rows="3" cols="50" name="comment"
									placeholder="write comment here ...."></textarea>
								<div>
									<input class="form-control" name="email" type="hidden"
										value=${email} >
								</div>
								<div>
									<input class="form-control" name="id" type="hidden"
										value="${post.id}">
								</div>
								<button type="submit" class="btn btn-secondary btn-lg">post</button>
							</form>
						</div>
						<hr>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script>
		function initialize() {
			var departure = document.getElementById("departure");
			var destination = document.getElementById("destination");
			var autocomplete = new google.maps.places.Autocomplete(departure);
			var autocomplete2 = new google.maps.places.Autocomplete(destination);

		}
		google.maps.event.addDomListener(window, 'load', initialize);

		$(document).ready(function() {
			$('#cars').on('change', function() {

				let seats = $(this).val();
				let option = "";
				for (let i = 0; i < seats; i++) {
					option = $('<option>', {
						'text' : i + 1,
						'value' : i + 1
					});
					$('#noOfSeats').append(option);
				}
			})
		})
	</script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAmMANqWLDs12mTUiiX4SuLJeftpYyQdgk&libraries=places"></script>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>

