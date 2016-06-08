<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 6/2/16
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>Fisherman Place</title>
    </head>
    <body>

        <jsp:include page="fragments/header.jsp"/>

        <%--Container--%>

        <div class="container">


            <div id="map"></div>

        </div>

        <%--JQuery--%>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

        <%--Bootstrap--%>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


        <%--Custom CSS--%>
        <link rel="stylesheet" type="text/css" href="resources/css/coordinates.css">

        <%--Google maps--%>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC7uD59aU-uCFNVqxFRZAXPte6ITsjDeXI&callback=initMap"
        async defer></script>


        <%--Custom Scripts--%>
        <script>


            var map;
            function initMap(position) {
                if (position == null) {
                    position = {lat: 50.4501, lng: 30.5234}
                }
                map = new google.maps.Map(document.getElementById('map'), {
                    center: position,
                    zoom: 5
                });
            }

            function getCoordinatesId(id) {
                $.getJSON('/coordinates/' + id, function (data) {
                    initMap(data);

                    var infowindow = new google.maps.InfoWindow({
                        content: "test content"
                    });
                    var marker = new google.maps.Marker({
                        position: data,
                        map: map
                    });
                    marker.addListener('click', function () {
                        infowindow.open(map, marker);
                    })
                });
            }

            var counter = 1;

            function backward() {
                if (counter > 1) {
                    counter = 1;
                    getCoordinatesId(counter);
                    return;
                }
                getCoordinatesId(counter);
                counter--;
                alert(counter);
            }

            function forward() {
                if (counter > 3) {
                    counter = 3;
                    getCoordinatesId(counter);
                    return;
                }
                getCoordinatesId(counter);
                counter++;
                alert(counter);
            }

            function showAllPlaces() {
                $.getJSON('/coordinates/showAllPlaces', function (data) {
                    initMap(data);

                    var infowindow = new google.maps.InfoWindow({
                        content: "test content"
                    });
                    for (var i = 1; i < data.length(); i++) {
                        var marker = new google.maps.Marker({
                            position: data[i],
                            map: map
                        });

                        marker.addListener('click', function () {
                            infowindow.open(map, marker);
                        })
                    }

                });

            }

        </script>
    </body>
</html>