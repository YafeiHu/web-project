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
		xmlhttp.open("DELETE",  e.target.id, true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<div class="container">
		<h1>
			Book Manager
		</h1>
		<div class="span-12 last">
			<h3>Books</h3>
				<table class="data">
					<tr>
			    		<th>Title</th>
			    		<th>Author</th>
			    		<th>Author</th>
					</tr>
					<c:forEach items="${photos}" var="photo">
			    		<tr>
			    		<td><a href="photo/${photo.id}">${photo.id}</a></td>
			        		<td>
			    				<c:if test="${fn:length(photo.content) > 0}">
			    					<img src="http://localhost:8081/coe/photo/${photo.id}" onclick=ResizeImage(this,520)/>
			    				</c:if>
			    			</td>
			        		<td><a href="#" id="${photo.id}" onclick="deleteE(event)">Delete</a></td>
			    		</tr>
					</c:forEach>
				</table>
		</div>
	</div>

	
</body>
</html>