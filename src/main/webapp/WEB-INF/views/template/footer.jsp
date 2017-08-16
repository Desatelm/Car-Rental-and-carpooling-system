

<hr>

<footer>
    <p align="center">&copy; 2017 TeamFire, Inc.</p>
</footer>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
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
				for (let i = 0; i < seats; i++) {
					let option = $('<option>', {
						'text' : i + 1 ,
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
<script src="<c:url value="/static/js/custome.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
<%-- <script src="<c:url value="/static/js/user.js"/>"></script> --%>
</body>
</html>
