<%@page import="model.VIP"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Attendant"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="health club attendant index page" />
<meta name="author" content="zhang xu fan" />
<link rel="shortcut icon"
	href="<s:url value="/material/logo.ico"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/bootstrap.css"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/customize.css"></s:url>" />
<%
	Attendant attendant = (Attendant) session.getAttribute("attendant");
	String name = attendant.getName();
%>
<title>HealthClub--<%=name%>--index
</title>
</head>
<body>
	<s:div cssClass="navbar navbar-inverse navbar-fixed-top">
		<s:div cssClass="container">
			<s:div cssClass="navbar-header">
				<a href="<s:url value="/index.jsp"></s:url>"><img alt="logo"
					src="<s:url value="/material/HealthClub.png"></s:url>" /></a>
			</s:div>
			<s:div cssClass="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a>Hello, &nbsp; <%=attendant.getName()%>
					</a></li>
					<li><a href="<s:url value="/attendant/index.jsp"></s:url>">Home</a></li>
					<li><s:a action="showmember" namespace="/action">Member</s:a></li>
					<li><s:a action="showactivity" namespace="/action">
							<s:param name="a_id" value="%{#session.attendant.a_id}"></s:param>Activity</s:a></li>
				</ul>
			</s:div>
		</s:div>
	</s:div>
	<s:div cssClass="container">
		<s:div cssClass="row row-offcanvas row-offcanvas-right">
			<s:div cssClass="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>
				<s:div cssClass="jumbotron">
					<h1>
						Hello,&nbsp;<%=attendant.getName()%>!
					</h1>
					<p>Welcome to your personal home page, you can see what you can
						do here.</p>
				</s:div>
				<s:div cssClass="row">
					<s:div cssClass="col-6 col-sm-6 col-lg-4">
						<h2>
							<s:a action="showmember" namespace="/action">
								<s:param name="a_id" value="%{#session.attendant.a_id}"></s:param>VIP Management</s:a>
						</h2>
						<p>You can see members registered to the Health Club, and view
							the details.</p>
					</s:div>
					<s:div cssClass="col-6 col-sm-6 col-lg-4">
						<h2>
							<s:a action="showactivity" namespace="/action">
								<s:param name="a_id" value="%{#session.attendant.a_id}"></s:param>Activity/Course</s:a>
						</h2>
						<p>You can see all activities in Health Club and modify
							activities published by you.</p>
					</s:div>
				</s:div>
			</s:div>
			<s:div cssClass="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<s:div cssClass="list-group">
					<s:a cssClass="list-group-item" action="showmember"
						namespace="/action">VIP &nbsp;Management</s:a>
					<s:a cssClass="list-group-item" action="showactivity"
						namespace="/action">
						<s:param name="a_id" value="%{#session.attendant.a_id}"></s:param>Activity &nbsp;Management
						</s:a>
				</s:div>
			</s:div>
		</s:div>
	</s:div>
</body>
</html>