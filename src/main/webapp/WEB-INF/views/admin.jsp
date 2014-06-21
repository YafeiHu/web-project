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
</style>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" rel="home" href="#">Brand</a>
		</div>

		<div class="collapse navbar-collapse">

			<ul class="nav navbar-nav">
				<li><a href="http://localhost:8081/coe/continent/countrylist">continent</a></li>
				<li><a href="http://localhost:8081/coe/country/addcountry">country</a></li>
				<li><a href="http://localhost:8081/coe/city/addcity">city</a></li>
				<li><a href="http://localhost:8081/coe/user/userlist">user</a></li>
				<li><a href="http://localhost:8081/coe/user/userlist">food</a></li>
				<li><a href="http://localhost:8081/coe/user/userlist">sight</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Dropdown <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>

			<div class="col-sm-3 col-md-3 pull-right">
				<form class="navbar-form" role="search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="srch-term" id="srch-term">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>


	<div class="row wrap">

		<!--center-->
		<div class="col-sm-9">
			<hr>
			<div class="row">
				<div class="col-xs-12">
					<div class="container">
						<h1>country list</h1>
						<nav id="filter" class="col-md-12 text-center">
							<ul id="countrytab">
								<li class="current"><a href="javascript:void(0);"
									data-continent="allcountry" class="current btn-theme btn-small">all</a></li>
								<c:forEach items="${continents}" var="continent">
									<li><a href="javascript:void(0);"
										data-continent="${continent.name}" class="btn-theme btn-small">${continent.name}</a></li>
								</c:forEach>
							</ul>
						</nav>
						<div class="countrylists">
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
			<hr>
		</div>
		<!--/center-->


		<hr>
	</div>
	<!-- /.container -->


</body>
</html>
