<%@page import="model.Activity"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Attendant"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="health club view activity page" />
<meta name="author" content="zhang xu fan" />
<link rel="shortcut icon"
	href="<s:url value="/material/logo.ico"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/bootstrap.css"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/customize.css"></s:url>" />
<%
	Attendant attendant = (Attendant) session.getAttribute("attendant");
	String name = attendant.getName();
%>
<title>HealthClub--<%=name%>--viewactivity
</title>
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
					<%
						@SuppressWarnings("unchecked")
										ArrayList<Activity> activities = (ArrayList<Activity>) request
												.getAttribute("activities");
										if (activities == null) {
					%>
					<h3>Oops, there is no activity published till now.&gt;_&lt;</h3>
					<%
						} else {
											int size = activities.size();
					%>
					<h3>
						<%=size%>
						<%=(size == 1) ? "activity"
										: "activities"%>
						are published.
					</h3>
					<s:iterator value="%{#request.activities}" status="st">
						<s:div cssClass="card">
							<s:iterator value="%{#request.activities.get(#st.index)}">
								<s:a cssClass="btn btn-lg btn-primary view"
									action="viewactivity" namespace="/action">
									<s:param name="ac_id"
										value="%{#request.activities.get(#st.index).ac_id}"></s:param>View</s:a>
								<h4>
									Activity Name:&nbsp;
									<s:property
										value="%{#request.activities.get(#st.index).ac_name}" />
								</h4>
								<h4>
									Place:&nbsp;
									<s:property
										value="%{#request.activities.get(#st.index).place.location}" />
								</h4>
								<h4>
									Start Date:&nbsp;
									<s:property
										value="%{#request.activities.get(#st.index).startDate}" />
								</h4>
								<h4>
									End Date:&nbsp;
									<s:property
										value="%{#request.activities.get(#st.index).endDate}" />
								</h4>
							</s:iterator>
						</s:div>
					</s:iterator>
					<%
						}
					%>
					<s:a action="requestaddactivity" cssClass="btn btn-lg btn-primary">
						<s:param name="a_id" value="%{#session.attendant.a_id}"></s:param>Add New Activity</s:a>
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