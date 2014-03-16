<%@page import="model.Attendant"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="health club add activity page" />
<meta name="author" content="zhang xu fan" />
<link rel="shortcut icon"
	href="<s:url value="/material/logo.ico"></s:url>" />
<%
	Attendant attendant = (Attendant) session.getAttribute("attendant");
	String name = attendant.getName();
%>
<title>HealthClub--<%=name%>--viewactivity
</title>
<script src="<s:url value="/js/jquery-1.11.0.js"></s:url>"></script>
<link id="bs-css" href="<s:url value="/css/bootstrap.min.css"></s:url>"
	rel="stylesheet">
<link id="bsdp-css" href="<s:url value="/css/datepicker3.css"></s:url>"
	rel="stylesheet">

<script src="<s:url value="/js/bootstrap-datepicker.js"></s:url>"></script>
<link rel="stylesheet" href="<s:url value="/css/bootstrap.css"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/customize.css"></s:url>" />
</head>
<body>
	<s:div cssClass="navbar navbar-inverse navbar-fixed-top">
		<s:div cssClass="container">
			<s:div cssClass="navbar-header">
				<a href="<s:url value="/index.jsp"></s:url>"><img alt="logo"
					src="<s:url value="/material/HealthClub.png"></s:url>"></a>
			</s:div>
			<s:div cssClass="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a>Hello, &nbsp;<%=attendant.getName()%></a></li>
					<li><a href="<s:url value="/attendant/index.jsp"></s:url>">Home</a></li>
					<li><s:a action="showmember" namespace="/action">Member</s:a></li>
					<li><s:a action="showactivity" namespace="/action">Activity</s:a></li>
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
					<p>You can view all activities and modify activities published
						by you.</p>
				</s:div>
				<s:div cssClass="layout module">
					<strong>Add New Activity</strong>
					<hr>
					<s:form cssClass="form-activity" action="addactivity"
						name="addactivity" method="post" namespace="/action">
						<span>Please fill activity information</span>
						<input type="text" class="form-control"
							placeholder="Activity Name" name="ac_name">
						<br>
						<input type="text" class="form-control" placeholder="Location"
							name="location">
						<br>
						<s:div cssClass="span5 col-md-14" id="sandbox-container">
							Date:&nbsp;
							<s:div cssClass="input-daterange input-group" id="datepicker">
								<input type="text" class="input-sm form-control" name="start" />
								<span class="input-group-addon">to</span>
								<input type="text" class="input-sm form-control" name="end" />
							</s:div>
						</s:div>
						<br>
						<s:a cssClass="btn btn-primary btn-lg" action="addactivity">Publish</s:a>
					</s:form>
				</s:div>
			</s:div>
			<s:div cssClass="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<s:div cssClass="list-group">
					<s:a cssClass="list-group-item" action="showmember"
						namespace="/action">VIP &nbsp;Management</s:a>
					<s:a cssClass="list-group-item" action="showactivity"
						namespace="/action">Activity &nbsp;Management</s:a>
				</s:div>
			</s:div>
		</s:div>
	</s:div>
</body>
</html>
