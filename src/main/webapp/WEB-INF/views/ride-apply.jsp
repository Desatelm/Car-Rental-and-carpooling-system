<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/secureheader.jsp"%>
<div class="container">
	<div class="row">
		<div class="col">
		<h3>Ride Information</h3>
			<P>Leaving from : ${ride.departure}</P>
			<P>Destination :${ride.destination}</P>
			<P>When :${ride.departureDate}</p>
			<p>${ride.departureTime}</P>
			<P>:</P>
		</div>
		<div class="col">
			<div class="row">
				<h3>Driver Information</h3>
				<P>Name :</P>
				<P>Age :</P>
				<P></P>
			</div>
			<div class="row">
				<h3>Select Number of seats</h3>
				<select>
					<option>1 seat</option>
					<option>2 seat</option>
				</select>
				<button>Book and Make a Payment</button>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>