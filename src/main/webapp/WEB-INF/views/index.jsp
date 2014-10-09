<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Data Visualization</title>

<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.10.4.custom.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div id="wrapper">

		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#billing-metrics-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><fmt:message key="top.header" /></a>
			</div>
			
			<!--  
			<div class="collapse navbar-collapse" id="billing-metrics-navbar-collapse-1">
					<a href="?lang=en">en</a> | <a href="?lang=de">de</a>
			</div>
			-->

		</nav>
		<div id="row">
			<div class="col-md-1">&nbsp;</div>
		</div>
		<div id="page-wrapper">
			<div class="row">
			   
				<div class="col-lg-12">
					<a href="${pageContext.request.contextPath}/search"><fmt:message key="Search"/></a><br />
				</div>
				<div class="col-lg-12">
					<a href="${pageContext.request.contextPath}/imdb">IMDB</a><br />
				</div>
				<div class="col-lg-12">
					<a href="${pageContext.request.contextPath}/imdb/setup.html">IMDB Set Up</a><br />
				</div>
	
				<div class="col-lg-12">
					<a href="${pageContext.request.contextPath}/charts"><fmt:message key="Charts"/></a><br />
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-lg-12">
				    <br/>
				    
					<a href="?lang=en">en</a>   | <a href="?lang=es">es</a> | <a href="?lang=pt">pt</a> | <a href="?lang=de">de</a>
				</div>
			</div>
			
			<!--  
			<div class="row">
				<div class="col-lg-12">
				    <br/>
				    <br/>
				    <br/>
				    <img src="${pageContext.request.contextPath}/resources/img/hack-context.jpg"> 
					
				</div>
			</div>
			-->
			
		</div>

	</div>

	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</body>
</html>
