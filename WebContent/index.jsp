<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="health club index page" />
<meta name="author" content="zhang xu fan" />
<link rel="shortcut icon" href="./material/logo.ico" />
<link rel="stylesheet" href="./css/bootstrap.css" />
<title>Health Club--index</title>
</head>
<body>
	<s:div cssClass="navbar navbar-inverse navbar-fixed-top">
		<s:div cssClass="container">
			<s:div cssClass="navbar-header">
				<a href="index.jsp"> <img alt="logo"
					src="<s:url value="./material/HealthClub.png"></s:url>" />
				</a>
			</s:div>
			<s:div cssClass="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><s:a href="index.jsp">Home</s:a></li>
					<li><s:a href="./member/register.jsp">Register</s:a></li>
					<li><s:a href="./member/login.jsp">Login</s:a></li>
				</ul>
			</s:div>
		</s:div>
	</s:div>
</body>
</html>