"use strict";

$(document).ready(function () {

    mapboxgl.accessToken = mapboxToken; // Variable linking Mapbox API token

//-----------------------------------------------

    let map = new mapboxgl.Map({ // Mapbox API map styling and location origin
        container: "map",
        style: "mapbox://styles/mapbox/streets-v9",
        center: [-98.4896, 29.4268], // Coordinates for Codeup in San Antonio, TX
        zoom: 11
    });

//-----------------------------------------------

    let geoCoder = new MapboxGeocoder({ // Mapbox API geocoder to retrieve coordinates from text entered in Search box
        accessToken: mapboxgl.accessToken,
        marker: false,
        mapboxgl: mapboxgl
    });

    map.addControl(geoCoder); // Takes in geoCoder variable above

    geoCoder.on("result", function(e){ // Mapbox API geoCoder function will return data object for location typed into Search box...only console log "e" to retrieve the whole object, or use the specificity present to only retrieve MapBox API coordinates
        console.log(e); // Mapbox API geocoder will return data object with location information
        marker.setLngLat([e.result.geometry.coordinates[0], e.result.geometry.coordinates[1]]); // Grabs latitude[0] and longitude[1] for data object searched for (e.g. anywhere else than starting point)
        marker.addTo(map); // Places new marker at coordinates for data object searched (e.g. anywhere else than starting point)
        getWeather(e.result.geometry.coordinates[1], e.result.geometry.coordinates[0]); // Pings DarkSky API with MapBox API coordinates retrieved on Search
    });

//-----------------------------------------------

    let marker = new mapboxgl.Marker({ // Mapbox API marker customization
        draggable: true,
        color: "purple"
    })
        .setLngLat([-98.4896, 29.4268]) // Coordinates for Codeup in San Antonio, TX
        .addTo(map);

//-----------------------------------------------

    let coordinates = document.getElementById("coordinates"); // Mapbox API variable for onDragEnd and reverseGeocode functions

//-----------------------------------------------

    function onDragEnd(lat, lng) { // Mapbox API displays marker coordinates on bottom left of map after drag
        let lngLat = marker.getLngLat();
        coordinates.style.display = "block";
        coordinates.innerHTML = "Longitude: " + lngLat.lng + "<br>Latitude: " + lngLat.lat;
    }
    marker.on("dragend", onDragEnd); // At end of marker drag interaction ("dragend"), run the onDragEnd function
    marker.on("dragend", getWeather); // At end of marker drag interaction ('dragend'), run the getWeather function

//---------------MAP EMBELLISHMENTS: START--------------------

    let nav = new mapboxgl.NavigationControl(); // Mapbox API adds map zoom and controls to desired location (e.g. 'top-left')
    map.addControl(nav, "top-left");

//-----------------------------------------------

    map.addControl(new mapboxgl.GeolocateControl({ // Mapbox API adds a button to define current user location on map
        positionOptions: {
            enableHighAccuracy: true
        },
        trackUserLocation: true
    }));

//-----------------------------------------------

    map.addControl(new mapboxgl.FullscreenControl({container: document.querySelector('#map')})); // Mapbox API will add a full screen button to map, showing targeted elements

//-----------------------------------------------

    let layerList = document.getElementById("menu"); // Mapbox API adds radio buttons to change map styling
    let inputs = layerList.getElementsByTagName("input");

    function switchLayer(layer) {
        let layerId = layer.target.id;
        map.setStyle("mapbox://styles/mapbox/" + layerId);
    }

    for (let i = 0; i < inputs.length; i++) {
        inputs[i].onclick = switchLayer;
    }
    function getWeather(latitude, longitude) {

        latitude = marker.getLngLat().lat; // Defines latitude and longitude with MapBox API coordinates
        longitude = marker.getLngLat().lng;

//---------------MAP EMBELLISHMENTS: END--------------------

        $.ajax("https://cors-anywhere.herokuapp.com/https://api.darksky.net/forecast/" + darkSkyKey + "/" + latitude + "," + longitude).done(function (data) {
            console.log(data); // Will retrieve DarkSky API object with weather information for MapBox API coordinates (e.g. marker.getLngLat().lat/marker.getLngLat().lng) in "getWeather" function

            //-----------------------------------------------

            makeDay1(data); // Generates selected weather info for three days
            makeDay2(data);
            makeDay3(data);

            //-----------------------------------------------

            reverseGeocode({ // Retrieve address text from marker coordinates on dragEnd
                    lng: marker.getLngLat().lng,
                    lat: marker.getLngLat().lat
                },
                mapboxgl.accessToken).then(function (results) {
                // console.log(results); // Console log entire data object retrieved from MapBox API reverseGeoCoder

                $("#location_name").html( // Display address text in #location_name div
                    "<div>" + "3-Day Forecast For: " + "</div>" + "<div>" + results.features[0].place_name + "</div>");// Only show the place_name for the data object retrieved
            });

            //-----------------------------------------------

        });
    }

    //-----------------------------------------------

    getWeather(29.4268,-98.4896); // Pings DarkSky API to return current weather conditions for Codeup in San Antonio, TX

    //-----------------------------------------------

    function makeDay1(data) { // Explicitly pulls targeted properties from returned DarkSky API object

        $("#day1").html(
            "<div class='text-center' style='background-color:whitesmoke'>" +
            "<h4>" + "High " + data.daily.data[0].temperatureMax + "&#176" + " / " + "Low: " + data.daily.data[0].temperatureMin + "&#176" + "</h4>" +
            "<div><img class='weather_icon' alt='icon' src='../img/" + data.daily.data[0].icon + ".gif'" + "</div>" +
            "<div>" + "<strong>Summary: </strong>" + "<em>" + data.daily.data[0].summary + "</em>" + "</div>" +
            "<div>" + "<strong>Humidity [0-1]: </strong>" + data.daily.data[0].humidity + "%" + "</div>" +
            "<div>" + "<strong>Wind: </strong>" + data.daily.data[0].windSpeed + " mph" + "</div>" +
            "<div>" + "<strong>Precipitation [0-1]: </strong>" + data.daily.data[0].precipProbability + "%" + "</div>" +
            "<div>" + "<strong>" + "Date: </strong>" + new Date(data.daily.data[0].time * 1000).toDateString() + "</div>" +
            "</div>");
    }

    function makeDay2(data) {

        $("#day2").html(
            "<div class='text-center' style='background-color:whitesmoke'>" +
            "<h4>" + "High " + data.daily.data[1].temperatureMax + "&#176" + " / " + "Low: " + data.daily.data[1].temperatureMin + "&#176" + "</h4>" +
            "<div><img class='weather_icon' alt='icon' src='../img/" + data.daily.data[1].icon + ".gif'" + "</div>" +
            "<div>" + "<strong>Summary: </strong>" + "<em>" + data.daily.data[1].summary + "</em>" + "</div>" +
            "<div>" + "<strong>Humidity [0-1]: </strong>" + data.daily.data[1].humidity + "%" + "</div>" +
            "<div>" + "<strong>Wind: </strong>" + data.daily.data[1].windSpeed + " mph" + "</div>" +
            "<div>" + "<strong>Precipitation [0-1]: </strong>" + data.daily.data[1].precipProbability + "%" + "</div>" +
            "<div>" + "<strong>" + "Date: </strong>" + new Date(data.daily.data[1].time * 1000).toDateString() + "</div>" +
            "</div>");
    }

    function makeDay3(data) {

        $("#day3").html(
            "<div class='text-center' style='background-color:whitesmoke'>" +
            "<h4>" + "High " + data.daily.data[2].temperatureMax + "&#176" + " / " + "Low: " + data.daily.data[2].temperatureMin + "&#176" + "</h4>" +
            "<div><img class='weather_icon' alt='icon' src='../img/" + data.daily.data[2].icon + ".gif'" + "</div>" +
            "<div>" + "<strong>Summary: </strong>" + "<em>" + data.daily.data[2].summary + "</em>" + "</div>" +
            "<div>" + "<strong>Humidity [0-1]: </strong>" + data.daily.data[2].humidity + "%" + "</div>" +
            "<div>" + "<strong>Wind: </strong>" + data.daily.data[2].windSpeed + " mph" + "</div>" +
            "<div>" + "<strong>Precipitation [0-1]: </strong>" + data.daily.data[2].precipProbability + "%" + "</div>" +
            "<div>" + "<strong>" + "Date: </strong>" + new Date(data.daily.data[2].time * 1000).toDateString() + "</div>" +
            "</div>");
    }
});
