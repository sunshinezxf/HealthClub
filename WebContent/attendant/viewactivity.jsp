<%@page import="model.record.ActivityRecord"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Activity"%>
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
<meta name="description" content="health club view member detail page" />
<meta name="author" content="zhang xu fan" />
<link rel="shortcut icon"
	href="<s:url value="/material/logo.ico"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/bootstrap.css"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/customize.css"></s:url>" />
<%
	Attendant attendant = (Attendant) session.getAttribute("attendant");
	String name = attendant.getName();
%>
<title>HealthClub--<%=name%>--viewdetail
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
					<li><a>Hello, &nbsp;<%=name%></a></li>
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
						Hello,&nbsp;<%=name%>!
					</h1>
					<p>You are now viewing the detail information of an activity.</p>
				</s:div>
				<s:div cssClass="layout module">
					<%
						Activity activity = (Activity) request
												.getAttribute("activity");
										@SuppressWarnings("unchecked")
										ArrayList<ActivityRecord> list = (ArrayList<ActivityRecord>) request
												.getAttribute("record");
					%>
					<s:form cssClass="card">
						<s:div cssClass="information">
							<h4>Activity Name:&nbsp;</h4>
							<input type="text" class="form-control" style="display: none;"
								value=<%=activity.getAc_id()%> name="ac_id" />
							<input type="text" class="form-control"
								value=<%=activity.getAc_name()%> name="ac_name" />
							<input type="text" class="form-control" style="display: none;"
								value=<%=activity.getA_id()%> />
						</s:div>
						<s:div cssClass="information">
							<h4>Place:&nbsp;</h4>
							<%
								String location = activity.getLocation();
							%>
							<input type="text" class="form-control" value='<%=location%>'
								name="location" />
						</s:div>
						<s:div cssClass="span5 col-md-14">
							<h4>Date:&nbsp;</h4>
							<s:div cssClass="input-daterange input-group">
								<input type="text" class="input-sm form-control"
									value=<%=activity.getStartDate()%> name="startDate" />
								<span class="input-group-addon">to</span>
								<input type="text" class="input-sm form-control"
									value=<%=activity.getEndDate()%> name="endDate" />
							</s:div>
						</s:div>
						<s:div cssClass="information">
							<h4>Coach No:&nbsp;</h4>
							<input type="text" class="form-control"
								value=<%=activity.getCoach_no()%> name="coach_no" />
						</s:div>
						<hr>
						<%
							if (list.size() == 0) {
						%>
						<p>No one has reserved the activity.</p>
						<%
							} else {
						%>
						<p>VIPs who has reserved the activity:</p>
						<s:iterator value="%{#request.record}" status="st">
							<s:div style="background-color:white;">
								<s:iterator value="%{#request.record.get(#st.index)}">
									<h5>
										Username:
										<s:property value="%{#request.record.get(#st.index).username}" />
										&nbsp; Coach No:
										<s:property value="%{#request.record.get(#st.index).co_no}" />
										&nbsp; Attended: <input type="checkbox" />
									</h5>
								</s:iterator>
							</s:div>
						</s:iterator>
						<%
							}
						%>
						<s:div cssClass="information">
							<button class="btn btn-primary btn-lg" type="submit">Confirm</button>
						</s:div>
					</s:form>
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