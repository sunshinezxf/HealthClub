<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.VIP"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="health club vip index page" />
<meta name="author" content="zhang xu fan" />
<link rel="shortcut icon"
	href="<s:url value="/material/logo.ico"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/bootstrap.css"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/customize.css"></s:url>" />
<%
	VIP vip = (VIP) session.getAttribute("vip");
%>
<title>Health Club--<%=vip.getName()%></title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="<s:url value="/member/index.jsp"></s:url>"><img
					alt="logo" src="<s:url value="/material/HealthClub.png"></s:url>" /></a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<s:url value="/member/index.jsp"></s:url>">Home</a></li>
					<li><a href="<s:url value="/member/index.jsp"></s:url>">Personal
							Information</a></li>
					<li><a href="<s:url value="/member/index.jsp"></s:url>">Quit</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="jumbotron">
					<h1>
						Hello,&nbsp;
						<%=vip.getName()%></h1>
					<p>Welcome to your personal home page, your can see what you
						can do here.</p>
				</div>
				<div class="row">
					<div class="col-6 col-sm-6 col-lg-4">
						<h2>Function 1</h2>
						<p>What you can do with Function 1</p>
					</div>
					<div class="col-6 col-sm-6 col-lg-4">
						<h2>Function 2</h2>
						<p>What you can do with Function 2</p>
					</div>
					<div class="col-6 col-sm-6 col-lg-4">
						<h2>Function 3</h2>
						<p>What you can do with Function 3</p>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 sidebar-ofcanvas" id="sidebar">
					<div class="list-group">
						<a href="#" class="list-group-item">Link</a>
						<a href="#" class="list-group-item">Link</a>
						<a href="#" class="list-group-item">Link</a>
					</div>
				</div>
		</div>
	</div>
</body>
</html>