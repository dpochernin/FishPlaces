<%--
  Created by IntelliJ IDEA.
  User: oleg_svitskiy
  Date: 6/5/16
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/coordinates">Fisherman Place</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/coordinates">Home</a></li>
                <li><a href="/add">Add Marker</a></li>
                <li><a onclick="showAllPlaces()">List all markers</a></li>
                <li><a onclick="backward()">Backward</a></li>
                <li><a onclick="forward()">Forward</a></li>
                <li><a>Choose random place</a> </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>