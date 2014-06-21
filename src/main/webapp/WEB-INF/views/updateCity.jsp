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
<link
	href="<c:url value="/resources/js/fancybox/jquery.fancybox.css" />"
	rel="stylesheet" type="text/css" media="screen">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<!--script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script-->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<!--script src="http://code.jquery.com/jquery-1.11.0.min.js"></script-->

<script type='text/javascript'
	src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script type='text/javascript'
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<!--script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script-->

<!--script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.easing.1.3.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.isotope.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.nicescroll.min.js"/>"></script-->
<script
	src="<c:url value="/resources/js/fancybox/jquery.fancybox.pack.js"/>"></script>
<script src="<c:url value="/resources/js/skrollr.min.js"/>"></script>
<script
	src="<c:url value="/resources/js/jquery.scrollTo-1.4.3.1-min.js"/>"></script>
<script
	src="<c:url value="/resources/js/jquery.localscroll-1.2.7-min.js"/>"></script>
<!--script src="<c:url value="/resources/js/stellar.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.appear.js"/>"></script>
<script src="<c:url value="/resources/js/validate.js"/>"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script-->
<script type="text/javascript">
function refreshParent() {
	window.opener.location.href = window.opener.location.href;
	if (window.opener.progressWindow) {
		window.opener.progressWindow.close();
	}
	window.close();
	//window.dialogArguments.reloadPage();
	//window.close();

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
	<form:form method="post"
		action="http://localhost:8081/coe/city/${city.id}/updatecity"
		commandName="city" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="cityname" cssErrorClass="error">City Name</form:label></td>
				<td><form:input path="cityname" value=""/></td>
			</tr>
			<tr>
				<td>Country<input type="text" name="country"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="update"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
