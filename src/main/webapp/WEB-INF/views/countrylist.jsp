<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title></title>
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
			country list
		</h1>
		<div class="span-12 last">
			<c:if test="${!empty countrys}">
				<table class="data">
					<tr>
						<th></th>
			    		<th>Title</th>
			    		<th>Author</th>
			    		<th>Quantity</th>
					</tr>
					<c:forEach items="${countrys}" var="country">
			    		<tr>
			        		<td><a href="${country.id}">${country.countryname}</a></td>
			        		<td><a href="#" id="${country.id}" onclick="deleteE(event)">Delete</a></td>
			    		</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>