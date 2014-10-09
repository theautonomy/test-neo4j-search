<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Customer Search</title>

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
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#billing-metrics-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><fmt:message key="top.header"/></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="billing-metrics-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">First Metric <b class="caret"></b>
					</a>
						<ul class="dropdown-menu" id="primaryAxis">
							
						</ul>
					</li>
				</ul>
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Second Metric <b class="caret"></b> </a>
						<ul class="dropdown-menu" id="secondaryAxis">
							
						</ul>
					</li>
					<li></li>
				</ul>
				<form class="navbar-form navbar-left" role="search" id="dateRangeForm">
					<div class="form-group">
						<input id="startDate" type="text" class="form-control" placeholder="Start Date">
					</div>
					<div class="form-group">
						<input id="endDate" type="text" class="form-control" placeholder="End Date">
					</div>
					<button type="submit" class="btn btn-default" id="submitMetrics">Submit</button>
					<button type="submit" class="btn btn-default" id="resetMetrics"> Reset</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown user-dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> &nbsp;&nbsp; <%=request.getUserPrincipal().getName()%> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="fa fa-user"></i> Profile</a>
							</li>
							<li class="divider"></li>
							
							<security:authorize access="isAuthenticated()">
							<li><a href="<c:url value="/j_spring_security_logout"/>">Log out</a></li>
 							</security:authorize>
 							
						</ul></li>
				</ul>
			</div>
		</nav>
		
		
		<div class="row">
			<div class="col-md-1">&nbsp;</div>
		</div>
		
		
		<div id="page-wrapper">
		
			<div class="row">
				<div class="col-xs-8 col-md-8 col-lg-8" id="chartHolder">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								<i class="fa fa-long-arrow-right"></i> <fmt:message key="Charts"/> 
							</h3>
						</div>
					</div>
					<div id="container"></div>
				</div>
			</div>
		</div>
	</div>
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/d3.v3.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/CustomJS/charts1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/CustomJS/customJquery1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/canvasjs.min.js"></script>

	<input type="hidden" id="selectedPrimaryAxis" value=""/>
	<input type="hidden" id="selectedSecondaryAxis" value=""/>
	
</body>
</html>
