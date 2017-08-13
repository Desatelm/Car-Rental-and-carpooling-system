function initialize() {
var departure = document.getElementById('departure');
var destination= document.getElementById('destination');
var autocomplete = new google.maps.places.Autocomplete(departure);
var autocomplete2 = new google.maps.places.Autocomplete(destination);
}
google.maps.event.addDomListener(window, 'load', initialize);