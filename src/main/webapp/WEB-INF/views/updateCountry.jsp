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
	<!--div class="nav">
		<ul>
			<li><a href="http://localhost:8081/coe/continent/countrylist">Destination</a>
			</li>
		</ul>
	</div-->
	<!--div class="login">
		<ul>
			<li><a href="http://localhost:8081/coe/country">login</a></li>
			<li><a href="http://localhost:8081/coe/country">register</a></li>
		</ul>
	</div-->
	<form:form method="post"
		action="http://localhost:8081/coe/country/${country.id}/updatecountry"
		commandName="country" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="countryname">Country Name</form:label></td>
				<td><form:input path="countryname" value=""/></td>
			</tr>
			<tr>
				<td><form:label path="description">description</form:label></td>
				<td><form:input path="description" value=""/></td>
			</tr>
			<tr>
				<td><form:label path="passport">passport</form:label></td>
				<td><form:input path="passport" value=""/></td>
			</tr>
			<tr>
				<td><form:label path="sign">sign</form:label></td>
				<td><form:input path="sign" value=""/></td>
			</tr>
			<tr>
				<td><form:label path="consumption">consumption</form:label></td>
				<td><form:input path="consumption" value=""/></td>
			</tr>
			<tr>
				<td><form:label path="currency">currency</form:label></td>
				<td><form:input path="currency" value=""/></td>
			</tr>
			<tr>
				<td><form:label path="emergency">emergency</form:label></td>
				<td><form:input path="emergency" value=""/></td>
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
