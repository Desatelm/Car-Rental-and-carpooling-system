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
				<P>Name :${user.firstName} ${user.lastName}</P>
				<P></P>
			</div>
			<div class="row">
				<h3>Select Number of seats</h3>
				<select>
					<c:forEach var="i" begin="1" end="${ride.noSeat }">
						<option>I want to book "${i}" seat</option>
					</c:forEach>
				</select>
				<a class="btn btn-primary btn-default" href="#" role="button">Book and Make payment</a>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>