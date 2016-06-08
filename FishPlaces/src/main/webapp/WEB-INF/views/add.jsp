<%--
  Created by IntelliJ IDEA.
  User: oleg_svitskiy
  Date: 6/5/16
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>

<div class="container">

    <br>
    <br>
    <br>
    <br>
    <br>

    <form method="post" action="/add">
        <input type="text" name="place" placeholder="Place name"> <span></span>
        <input type="text" name="lat" placeholder="Latitude"><span></span>
        <input type="text" name="lng" placeholder="Longitude"><span></span>
        <button class="btn btn-default" type="submit">Add marker</button>
    </form>

</div>

<%--Custom CSS--%>
<link rel="stylesheet" type="text/css" href="/resources/css/add.css">

<%--JQuery--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<%--Bootstrap--%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</body>
</html>
