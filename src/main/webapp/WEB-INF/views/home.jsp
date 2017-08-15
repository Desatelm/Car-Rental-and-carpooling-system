<%@include file="/WEB-INF/views/template/header.jsp"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


	<br />
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
	</div>
	<!-- <div class="row" style="padding-top: 20px;">
		<div class="col-md-offset-1 col-md-4 "
			style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px;">
			<h1>Car-Pooling System</h1>
			<p>This is a template for a simple marketing or informational
				website. It includes a large callout called a jumbotron and three
				supporting pieces of content. Use it as a starting point to create
				something more unique.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn
					more &raquo;</a>
			</p>
		</div>


		<div class="col-md-offset-1 col-md-4 "
			style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px;">
			<h2>Offered A Ride and Get Maney</h2>
			<p>Donec id elit non mi porta gravida at eget metus. Fusce
				dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
				ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
				magna mollis euismod. Donec sed odio dui.</p>
			<p>
				<a class="btn btn-primary btn-default" href="#" role="button">View
					details &raquo;</a>
			</p>
		</div>
	</div>
	<div class="row" style="padding-top: 20px;">
		<div class="col-md-offset-1 col-md-4"
			style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px; margin-top: 20px;">
			<h2>Search For A Comfortable and Cheap price</h2>
			<p>Donec id elit non mi porta gravida at eget metus. Fusce
				dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
				ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
				magna mollis euismod. Donec sed odio dui.</p>
			<p>
				<a class="btn btn-primary btn-default" href="#" role="button">View
					details &raquo;</a>
			</p>
		</div>
		<div class="col-md-offset-1 col-md-4"
			style="background: rgba(0, 0, 0, 0.3); color: white; border-radius: 5px; margin-top: 20px;">
			<h2>Explore Interesting Places with low expence</h2>
			<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
				egestas eget quam. Vestibulum id ligula porta felis euismod semper.
				Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
				nibh, ut fermentum massa justo sit amet risus.</p>
			<p>
				<a class="btn btn-primary btn-default" href="#" role="button">View
					details &raquo;</a>
			</p>
		</div>

		<div style="height: 100px;"></div>
	</div>



	<footer style="margin-top: 150px;">
		<p align="center">
			<span
				style="background: rgba(0, 0, 0, 0.4); color: white; border-radius: 5px; padding: 5px;">&copy;
				2017 TeamFire, Inc.</span>
		</p>
	</footer>

</div>
/container


Bootstrap core JavaScript
==================================================
Placed at the end of the document so the pages load faster
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	window.jQuery
			|| document
					.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"><\/script>')
</script> -->
<script src="<c:url value="/static/js/custome.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>

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
</body>
</html>