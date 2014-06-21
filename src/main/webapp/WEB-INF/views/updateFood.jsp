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
<meta name="generator" content="Bootply" />
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
	<div class="container">
		<h1>edit food</h1>
	</div>
	<form:form method="post"
		action="http://localhost:8081/coe/food/${food.id}/editfood"
		commandName="food">
		<form:label path="foodname">Name</form:label>
		<form:input path="foodname" value="${food.foodname}" />
		<br />
		<form:label path="address">Address</form:label>
		<form:input path="address" value="${food.address}" />
		<br />
		<form:label path="path">Path</form:label>
		<form:input path="path" value="${food.path}" />
		<br />
		<form:label path="worktime">Worktime</form:label>
		<form:input path="worktime" value="${food.worktime}" />
		<br />
		<form:label path="url">Url</form:label>
		<form:input path="url" value="${food.url}" />
		<br />
		<form:label path="phone">Phone</form:label>
		<form:input path="phone" value="${food.phone}" />
		<br />
		<input type="hidden" name="city" value="${food.city.id}" />
		<br />
		<input type="submit" value="update" />
	</form:form>

	<ul>
		<c:if test="${!empty requests}">
			<c:forEach items="${foods}" var="request">
				<li><a href="http://localhost:8081/coe/request/${request.id}">${request.id}</a></li>
				<a href="http://localhost:8081/coe/request/${request.id}/approve">approve</a>
			</c:forEach>
		</c:if>
	</ul>
</body>
</html>
