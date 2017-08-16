<%@include file="/WEB-INF/views/template/header.jsp"%>

<%-- 

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<br/>
<div class="container">
	<form class="form-inline" action="/search" method="post">
		<label class="sr-only" for="departure"></label> <input type="text"
			class="form-control mb-2 mr-sm-2 mb-sm-0" name="departure"
			value="${departure }" id="departure" placeholder="Your Departure">
		<label class="sr-only" for="inlineFormInputGroup"></label>
		<div class="input-group mb-2 mr-sm-2 mb-sm-0">
			<input type="text" class="form-control" id="destination"
				value="${destination }" name="destination"
				placeholder="Your Destination">
		</div>

		<button type="submit" class="btn btn-primary">Search For a
			Ride</button>
	</form>
</div> --%>
<c:if test="${not empty rides or not empty seat}">
	<div class="jumbotron container">
		<h4>Ride From ${departure} To ${destination} is available</h4>
		<div class="row">
			<div class="filter col-sm-3">
				<h3>Search Filters</h3>
				<form action="<c:url value="/searchF"/>" method="post">
					<input type="hidden" name="departure" value="${departure }">
					<input type="hidden" name="destination" value="${destination }">
					<div class="form-group">
						<small>${dateError }</small>
						<input id="datepick" name="date" placeholder="MM/DD/YYY"
							type="text" value="${date }" class="form-control"
							required="required" />
					</div>
					<h5>
						Number of Seats Available
						<c:if test="${not empty seat }">(&gt;=${seat })</c:if>
					</h5>
					<select class="selectpicker form-control" required="required"
						name="seat">
						<option value="">All posted rides</option>
						<option value="1">Minimum 1 seats available</option>
						<option value="2">Minimum 2 seats available</option>
						<option value="3">Minimum 3 seats available</option>
						<option value="4">Minimum 4 seats available</option>
					</select>
					<button type="submit" class="btn btn-default">Filter</button>
				</form>
			</div>
			<div class="col-sm-9">
				<table class="table">
					<thead>
						<tr>
							<th>Date</th>
							<th>Departure</th>
							<th>Destination</th>
							<th>Price</th>
							<th>Pick up at</th>
							<th>Seat Available</th>
							<th>Status</th>
							<th>Vehicle</th>
						</tr>
					</thead>
					<c:forEach var="ride" items="${rides}">
						<tr>
							<td>${ride.departureDate }</td>
							<td>${departure }</td>
							<td>${destination}</td>
							<td>${ride.price }</td>
							<td>${ride.pickUp }</td>
							<td>${ride.noSeat }</td>
							<td>${ride.status }</td>
							<td>${ride.vehicle.model }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			 //<button type="submit" class="btn btn-default">Apply For a Ride</button>
		</div>
	</div>
</c:if>





<!-- Google Api -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAmMANqWLDs12mTUiiX4SuLJeftpYyQdgk&libraries=places"></script>
<script>
	function initialize() {
		var departure = document.getElementById("departure");
		var destination = document.getElementById("destination");
		var autocomplete = new google.maps.places.Autocomplete(departure);
		var autocomplete2 = new google.maps.places.Autocomplete(destination);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>