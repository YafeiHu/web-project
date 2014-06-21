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
<title>City</title>
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
		if (obj.height > 300)
			obj.height = 300;
		if (obj.width > 500)
			obj.width = 500;
	}
</script>
<script type="text/javascript">
			$(document).ready(function() {
				$(".edit_btn").click(function() {
					var value = $(this).attr("value");
					ajaxlogin(value);
				});
			});
			function ajaxlogin(value) {
				if ("${pageContext.request.userPrincipal.name}" =="") {
					login();
				} else
					edit(value);
			}

			function login() {
				$.ajax({
					url : "http://localhost:8081/coe/login",
					success:function(){
						window.showModalDialog('http://localhost:8081/coe/login', 'newwindow', 'height=500, width=400, top=0, left=0, toolbar=no, menubar=yes, scrollbars=yes,resizable=yes,location=no, status=no'); 
						window.location.reload(); 
						} 
				});
			}
			function edit(value) {
				$.ajax({
					url : value,
					success:function(){
						window.showModalDialog(value, 'newwindow', 'height=500, width=400, top=0, left=0, toolbar=no, menubar=yes, scrollbars=yes,resizable=yes,location=no, status=no'); 
						window.location.reload(); 
					}
				});
			}
			function reloadPage(){
				window.location.reload();}
			
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

.baack {
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
		<div class="col-sm-8">
			<div class="row">
				<div class="col-xs-12">
					<a href="http://localhost:8081/coe/city/${city.id}/food"
						class="btn btn-info">food</a> <a
						href="http://localhost:8081/coe/city/${city.id}/sight"
						class="btn btn-info">sight</a> 
						<button class="edit_btn btn btn-info"
								value="http://localhost:8081/coe/city/${city.id}/updatecity">update</button>
						<button class="edit_btn btn btn-info"
								value="http://localhost:8081/coe/city/${city.id}/addphoto">upload</button>
						<a
						href="http://localhost:8081/coe/food/addfood" class="btn btn-info">add
						food</a> <a href="http://localhost:8081/coe/sight/addsight"
						class="btn btn-info">add sight</a>
						<a href="http://localhost:8081/coe/sight/addsight"
						class="btn btn-info">view photo</a>
					<div>
						<a href="http://localhost:8081/coe/city/${city.id}"> <img
							src="http://localhost:8081/coe/photo/${city.coverphoto}"
							onload="resizeImage(this)" />
							<p class="title">${city.cityname}</p></a>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">food:</div>
						<div class="panel-body">
							<ul>
								<c:if test="${!empty foods}">
									<c:forEach items="${foods}" var="food">
										<li><a href="http://localhost:8081/coe/food/${food.id}">${food.foodname}</a></li>
									</c:forEach>
								</c:if>
							</ul>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">sight:</div>
						<div class="panel-body">
							<ul>
								<c:if test="${!empty sights}">
									<c:forEach items="${sights}" var="sight">
										<li><a href="http://localhost:8081/coe/sight/${sight.id}">${sight.sightname}</a></li>
									</c:forEach>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<hr>
		</div>
		<div class="col-sm-4">
			<div class="row">
				<div class="col-xs-12">
					<h2>city information</h2>
					<div class="panel panel-default">
						<div class="panel-heading">weather:</div>
						<div class="panel-body">${city.weather}</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">tax</div>
						<div class="panel-body">${city.tax}</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">life</div>
						<div class="panel-body">${city.life}</div>
					</div>
				</div>
			</div>
		</div>
		<!--/center-->
	</div>
	<!-- /.container -->


</body>
</html>
