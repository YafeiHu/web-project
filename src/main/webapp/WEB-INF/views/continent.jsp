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
	function resizeImage(obj) {
		if (obj.height > 100)
			obj.height = 200;
		if (obj.width > 100)
			obj.width = 150;
	}
</script>
<style type="text/css">
body {
	padding-top: 70px;
}

.wrap {
	margin-left: 0;
	margin-right: 0;
}

.navbar {
	background-color: #77CCDD;
	color: #ffffff;
	border-radius: 0;
}

.navbar-nav>li>a {
	color: #fff;
	padding-left: 20px;
	padding-right: 20px;
	border-left: 1px solid #66BBCC;
}

.navbar-nav>li:last-child>a {
	border-right: 1px solid #66BBCC;
}

.navbar-nav li a:hover {
	background-color: #66BBCC;
}

.navbar-nav>.open>a,.navbar-nav>.open>a:hover,.navbar-nav>.open>a:focus
	{
	color: #000;
	opacity: .9;
}

.navbar-brand {
	color: #fff;
}

.picture {
	background-image:
		url('http://pic.qyer.com/public/place/config/2014/04/17/1397723816');
	width: 1150px;
	height: 350px;
	color: white;
}

.infocus {
	position: relative;
	width: 600px;
	margin: 0 auto;
	padding: 20px;
	border-radius: 3px;
	background: rgba(0, 0, 0, 0.6);
	filter: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr='#4b000000', EndColorStr='#4b000000');
	color: #fff;
}
.baack{
	position: relative;
	width: 600px;
	margin: 0 auto;
	padding: 20px;
	border-radius: 3px;
	background: #FFFFFF;
	filter: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr='#4b000000', EndColorStr='#4b000000');
	color: black;
}
.countrylist{
position: relative;
}
</style>
</head>
<body>
	<div class="navbar navbar-static navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse"> <span
					class="glyphicon glyphicon-chevron-down"></span>
				</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a
						href="http://localhost:8081/coe/continent/continentlist">Destination</a></li>
					<li><a href="http://localhost:8081/coe/login">login</a></li>
					<li><a href="http://localhost:8081/coe/user">register</a></li>
				</ul>
				<ul class="nav nav-pills">
					<li class="dropdown all-camera-dropdown"><a
						class="dropdown-toggle" data-toggle="dropdown" href="#">
							Account <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li data-filter-camera-type="all"><a data-toggle="tab"><form
										method="get"
										action="http://localhost:8081/coe/user/updateuser">
										<input type="hidden" name="name"
											value="${pageContext.request.userPrincipal.name}"></input> <input
											type="submit" value="update" />
									</form></a></li>
							<c:url value="/j_spring_security_logout" var="logoutUrl" />
							<li data-filter-camera-type="all"><a data-toggle="tab"><a
									href="${logoutUrl}">Log Out</a></a></li>
						</ul></li>
				</ul>
				<ul class="nav pull-right navbar-nav">

					<li class="dropdown all-camera-dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><i
							class="glyphicon glyphicon-user"></i> <i
							class="glyphicon glyphicon-chevron-down"></i></a><b class="caret"></b>
						<ul class="dropdown-menu">
							<li data-filter-camera-type="all"><a data-toggle="tab"
								href="http://localhost:8081/coe/continent/continentlist">Destination</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>

	<hr>
	<div class="row wrap">

		<!--center-->
		<div class="col-sm-9">
			<div class="row">
				<div class="col-xs-12">
					<div class="baack">
						<h1>country list</h1>
						<div class="container">
							<h1>${continent.name}</h1>
							<a
								href="http://localhost:8081/coe/continent/${continent.id}/updatecontinent">update</a>
							<div id="menu"><a
											href="http://localhost:8081/coe/continent/${continent.id}/food"
											class="btn btn-info">food</a><a
											href="http://localhost:8081/coe/continent/${continent.id}/sight"
											class="btn btn-info">sight</a>
							</div>
							<div class="countrylists">
								<c:if test="${!empty countrys}">
									<c:forEach items="${countrys}" var="country">
									<a href="http://localhost:8081/coe/country/${country.id}">
													<img
													src="http://localhost:8081/coe/photo/${country.photo.id}"
													onload="resizeImage(this)" />
													<p>${country.countryname}</p>
											</a>
									</c:forEach>
								</c:if>
								<a href="http://localhost:8081/coe/country" class="btn btn-info">add country</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<hr>
		</div>
		<!--/center-->


		<hr>
	</div>
	<!-- /.container -->

</body>
</html>
