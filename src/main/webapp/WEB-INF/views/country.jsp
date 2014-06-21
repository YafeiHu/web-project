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
<title>Country</title>
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
<script type="text/javascript">
	jQuery(function($) {
		var listtab = $("#listtab");
		var lists = $("#lists");
		var lists_ul = lists.find("ul");
		var listtab_bg = listtab.find(".bg");
		var listtab_index = 0;
		var listtab_bg_left = -24;

		listtab.find("li").each(function(index, element) {
			$(this).mouseenter(function() {
				var left = 89 * index + poilisttab_bg_left;
				listtab_bg.css("left", left);
				lists_ul.hide().eq(index).show();
			});
		});
	});
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

.baack {
	float: left;
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

li {
	float: left;
	margin-right: 20px;
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
		<div class="col-sm-3">
			<div class="row">
				<div class="col-xs-12">
					<h2>country information</h2>
					<div class="panel panel-default">
						<div class="panel-heading">passport</div>
						<div class="panel-body">${country.passport}</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">sign</div>
						<div class="panel-body">${country.sign}</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">consumption</div>
						<div class="panel-body">${country.consumption}</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="row">
				<div class="col-xs-12">
						<h1>${country.countryname}</h1>
						<div id="menu">
						<button class="edit_btn btn btn-info"
								value="http://localhost:8081/coe/country/${country.id}/updatecountry">update</button>
								 <a
								href="http://localhost:8081/coe/country/${country.id}/food"
								class="btn btn-info">food</a> <a
								href="http://localhost:8081/coe/country/${country.id}/sight"
								class="btn btn-info">sight</a>
						</div>
							<h3>citys</h3>
							<div>
								<c:if test="${!empty citys}">
								<ul>
										<c:forEach items="${citys}" var="city">
										<li><a href="http://localhost:8081/coe/city/${city.id}">
													<img
													src="http://localhost:8081/coe/photo/${city.coverphoto}"
													onload="resizeImage(this)" />
													<p class="title">${city.cityname}</p>
											</a></li>
										</c:forEach>
										</ul>
								</c:if>
							</div>
						</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="row">
				<div class="col-xs-12">
					<h2>country information</h2>
					<div class="panel panel-default">
						<div class="panel-heading">description:</div>
						<div class="panel-body">${country.description}</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">currency</div>
						<div class="panel-body">${country.currency}</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">emergency</div>
						<div class="panel-body">${country.emergency}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
