<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Destination</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/isotope.css" />"
	rel="stylesheet" media="screen" type="text/css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script type='text/javascript'
	src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script type='text/javascript'
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {
		var countrytab = $("#countrytab");
		countrytab.find("a").click(function() {
			var data = $(this).attr("data-continent");
			countrytab.find("li").removeClass("current");
			$(this).parent().addClass("current");
			if (data == "allcountry") {
				$(".countrylist").css({
					"left" : "20px",
					"opacity" : "0"
				}).show().animate({
					"left" : "0",
					opacity : '1'
				});
			} else {
				$(".countrylist").hide();
				$("#" + data + "list").css({
					"left" : "20px",
					"opacity" : "0"
				}).show().animate({
					"left" : "0",
					opacity : '1'
				});
			}
		});
	})
	
	
	function deleteE(e) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
		  	xmlhttp = new XMLHttpRequest();
		}
		else { 
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		    	location.reload(true);
		    }
		}
		xmlhttp.open("DELETE", e.target.id, true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<div class="nav">
		<ul>
			<li><a href="http://localhost:8081/coe/continent/countrylist">Destination</a>
			</li>
		</ul>
	</div>
	<div class="login">
		<ul>
			<li><a href="http://localhost:8081/coe/country">login</a></li>
			<li><a href="http://localhost:8081/coe/country">register</a></li>
		</ul>
	</div>
	<!--div class="container">
		<h1>country list</h1>
		<ul id="countrytab">
		<li class="current"><a href="javascript:void(0);" data-continent="allcountry">all</a></li>
			<c:forEach items="${continents}" var="continent">
				<li><a href="javascript:void(0);" data-continent="${continent.name}">${continent.name}</a></li>
			</c:forEach>
		</ul>
		<div class="countrylists">
			<c:if test="${!empty continents}">
					<c:forEach items="${continents}" var="continent">
					<div class="countrylist" id="${continent.name}list">
						<a href="http://localhost:8081/coe/continent/${continent.id}">${continent.name}</a>
						<ul>
						<c:forEach items="${continent.countrys}" var="country">
							<li><a href="http://localhost:8081/coe/country/${country.id}">${country.countryname}</a></li>
						</c:forEach>
						</ul>
					</div>
					</c:forEach>
			</c:if>
		</div>
	</div-->
	<div class="container">
		<h1>country list</h1>
		<div class="span-12 last">
			<c:if test="${!empty countrys}">
				<c:forEach items="${countrys}" var="country">
					<ul>
						<li><a href="http://localhost:8081/coe/country/${country.id}">
								<img src="http://localhost:8081/coe/photo/${country.photo.id}" />
								<h3 class="title">${country.countryname}</h3>
						</a> <a href="#" id="http://localhost:8081/coe/country/${country.id}" onclick="deleteE(event)">Delete</a>
						</li>
					</ul>
				</c:forEach>
			</c:if>
		</div>
	</div>
	<form:form method="post"
		action="http://localhost:8081/coe/country/addcountry"
		commandName="country" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="countryname">Country Name</form:label></td>
				<td><form:input path="countryname" value=""/></td>
			</tr>
			<tr>
				<td>Continent<input type="text" name="continent" /></td>
			</tr>
			<tr>
				<td><input type="file" name="file" id="file"></input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Country" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
