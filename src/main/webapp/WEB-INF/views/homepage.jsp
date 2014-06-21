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
	$(document).ready(function() {
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
	});
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
	
}
.white{
color: white;
}
.black{
color: black;
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
							<li data-filter-camera-type="all">
							<a data-toggle="tab"><a href="${logoutUrl}" >Log Out</a></a></li>
						</ul></li>
				</ul>
				<ul class="nav pull-right navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>
							<i class="glyphicon glyphicon-chevron-down"></i></a>
						<ul class="dropdown-menu">
						<li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>

	<hr>
	<div class="row wrap">

		<!--center-->
		<div class="col-sm-9">
			<div class="row picture">
				<div class="col-xs-12">
					<div class="infocus">
						<h3 >Let's go now!</h3>
						<div class="span-12 last">
							<form action="http://localhost:8081/coe/city/getcity"
								method="post">
								destination name:<input type="text" name="name"
									placeholder="city name" class="black"/><br>
								<input type="submit" class="black"/>
							</form>
							<div>
								<!--a href="http://localhost:8081/coe/country/countrylist" class="white"> see
									all countries>></a-->
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-xs-12">
					<div class="baack">
						<h1>country list</h1>
							<div id="countrytab"><a
									href="javascript:void(0);" data-continent="allcountry"
									class="btn btn-info">all</a>
								<c:forEach items="${continents}" var="continent">
									<a href="javascript:void(0);" data-continent="${continent.name}"
										class="btn btn-info">${continent.name}</a>
								</c:forEach>
						<div class="countrylists">
						<div class="baack">
							<c:if test="${!empty continents}">
								<c:forEach items="${continents}" var="continent">
									<div class="countrylist" id="${continent.name}list">
										<a href="http://localhost:8081/coe/continent/${continent.id}">${continent.name}</a>
										<ul>
											<c:forEach items="${continent.countrys}" var="country">
												<li><a
													href="http://localhost:8081/coe/country/${country.id}">${country.countryname}</a></li>
											</c:forEach>
										</ul>
									</div>
								</c:forEach>
							</c:if>
						</div>
						</div>
					</div>
				</div>
			</div>
			<hr>
			
		</div>
		<!--/center-->

<a href="http://localhost:8081/coe/user/map">map</a>
		<hr>
	</div>
	<!-- /.container -->
</body>
</html>
