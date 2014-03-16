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
</body>
</html>