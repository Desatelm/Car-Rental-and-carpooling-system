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
				<form method="post" action="../booked">
					<select name= "seat">
						<c:forEach var="i" begin="1" end="${ride.noSeat }">
							<option value="${i}">I want to book ${i} seat</option>
						</c:forEach>
					</select> <input class="form-control" name="email" type="hidden"
						value=${email} > <input class="form-control" name="postId"
						type="hidden" value=${ride.id} > 
						<button type="submit" class="btn btn-secondary btn-lg">Book and Make payment</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>