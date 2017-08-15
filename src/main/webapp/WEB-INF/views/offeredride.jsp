<%@include file="/WEB-INF/views/template/secureheader.jsp"%>
<table class="table">
	<thead>
		<tr>
			<th>To</th>
			<th>From</th>
			<th>Date</th>
			<th>Price</th>
			<th>Pick up at</th>
			<th>Seat Available</th>
			<th>Status</th>
			<th>Vehicle</th>
		</tr>
	</thead>
	<c:forEach var="ride" items="${rides}">
		<tr>
			<td>${ride.destination }</td>
			<td>${ride.departure }</td>
			<td>${ride.departureDate }</td>
			<td>${ride.price }</td>
			<td>${ride.pickUp }</td>
			<td>${ride.noSeat }</td>
			<td>${ride.status }</td>
			<td>${ride.vehicle.model }</td>
		</tr>
	</c:forEach>
</table>

<%@include file="/WEB-INF/views/template/footer.jsp"%>