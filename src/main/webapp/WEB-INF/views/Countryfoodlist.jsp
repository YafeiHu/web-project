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
					<div class="container">
						<h1>${continent.name}food list</h1>
						<div class="side"></div>
						<div class="countrylists">
							<c:if test="${!empty foods}">
								<c:forEach items="${foods}" var="food">
									<div class="countrylist" id="${food.foodname}list">
										<ul>
											<li><a href="http://localhost:8081/coe/food/${food.id}">
													<img
													src="http://localhost:8081/coe/photo/${food.coverphoto}" />
													<h3 class="title">${food.foodname}</h3>
											</a></li>
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


	<hr>
	</div>
	<!-- /.container -->

</body>
</html>
