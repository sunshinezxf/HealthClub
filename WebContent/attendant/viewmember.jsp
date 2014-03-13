<%@page import="model.Gender"%>
<%@page import="model.Attendant"%>
<%@page import="model.VIP"%>
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
				<s:div cssClass="jumotron">
					<h1>
						Hello,&nbsp;<%=name%>!
					</h1>
					<p>You are now viewing member's detail information.</p>
				</s:div>
				<s:div cssClass="layout module">
					<%
						VIP vip = (VIP) request.getAttribute("vip");
					%>
					<s:div cssClass="information">
						<h4>
							Username:
							<%=vip.getUsername()%></h4>
						<h4>
							Name:
							<%=vip.getName()%></h4>
						<h4>
							Gender:
							<%=(vip.getGender() == Gender.MALE) ? "male"
										: "female"%></h4>
						<h4>
							Cellphone:
							<%=vip.getPhone().getNo()%></h4>
						<h4>
							Age:
							<%=vip.getAge()%></h4>
						<h4>
							Credit No:
							<%=vip.getCreditCard().getCr_no()%></h4>
						<h4>
							Cards:
							<s:iterator value="%{#request.vip.cardList}" status="st">
								<s:div cssClass="card">
									<s:iterator value="%{#request.vip.cardList.get(#st.index)}">
										<s:a cssClass="btn btn-lg btn-primary delete" action=""
											namespace="/action">
											<s:param name="v_id" value="%{#request.vip.v_id}"></s:param>Delete
										</s:a>
										<h5>
											Card No:
											<s:property
												value="%{#request.vip.cardList.get(#st.index).c_id}" />
										</h5>
										<h5>
											Card Type
											<s:property
												value="%{#request.vip.cardList.get(#st.index).type}" />
										</h5>
										<h5>
											Activated:
											<s:if
												test="%{#request.vip.cardList.get(#st.index).activated} == true">
												Already Activated
											</s:if>
											<s:else>
												Not Yet Activated
											</s:else>
										</h5>
										<h5>
											Payed:
											<s:if
												test="%{#request.vip.cardList.get(#st.index).payed} == true">
												Already Payed This Month
											</s:if>
											<s:else>
												Not Yet Payed
											</s:else>
										</h5>
									</s:iterator>
								</s:div>
							</s:iterator>
						</h4>
					</s:div>
				</s:div>
			</s:div>
			<s:div cssClass="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<s:div clss="list-group">
					<s:a cssClass="list-group-item" action="showmember"
						namespace="/action">VIP Management</s:a>
					<s:a cssClass="list-group-item">Activity Management</s:a>
				</s:div>
			</s:div>
		</s:div>
	</s:div>
</body>
</html>