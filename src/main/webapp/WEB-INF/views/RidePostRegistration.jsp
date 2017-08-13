<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/secureheader.jsp"%>

<%-- <div class="container">
	<div class="row">
		<div class="col-4">
			<form:form action="registerPost" method= "post">
				<div>
					Departure :
					<form:input id="departure" size="50" path="departure" />
				</div>
				<div>
					Destination:
					<form:input id="destination" size="50" path="destination" />
				</div>

				<div class="form-group registration-date">
					<div class="input-group registration-date-time">
						<div>
							Departure Date :
							<form:input class="form-control" name="registration_date"
								id="registration-date" path="departureDate" type="date" />
						</div>
						<div>
							Departure Time :
							<form:input class="form-control" name="registration_time"
								id="registration-time" path="departureTime" type="time" />
						</div>
					</div>
				</div>

				<div>
					Number of Seats:
					<form:input type="number" path="destination" />
				</div>

				<div>
					Price:
					<form:input type="number" path="destination" />
				</div>
				<div>
					viechle:
					<form:select path="vichele">
						<form:options items="${vicheleOptions}" />
					</form:select>
				</div>
				<div>
					Waiting Time
					<form:input path="destination" />
				</div>
				<div>
					<input type="submit" value="Submit">
				</div>
			</form:form>
		</div>
		<div class="col">1 of 2</div>
	</div>
</div>
 --%>

<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<form method="post" action="registed">
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
							Vichele: <select name="model" class="form-control">
								<option value="2009">2009</option>
								<option value="2010">2010</option>
								<option value="2011">2011</option>
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
							Waiting Time <input class="form-control" name="waitingTime" /> <input
								type="hidden" value=${email} form-control" name="email" />
						</div>

						<button type="submit" class="btn btn-secondary btn-lg">POST</button>

					</div>
				</fieldset>
			</form>
		</div>
		<div class="col-sm-8">
			<div>
				<h3>Display horizontal</h3>
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
	</script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAmMANqWLDs12mTUiiX4SuLJeftpYyQdgk&libraries=places"></script>

	<%@include file="/WEB-INF/views/template/footer.jsp"%>