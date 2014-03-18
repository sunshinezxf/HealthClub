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
<title>HealthClub--<%=name%>--modifydetail
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
					<p>You are now modifying member's detail information.</p>
				</s:div>
				<s:div cssClass="layout module">
					<%
						VIP vip = (VIP) request.getAttribute("vip");
					%>
					<s:form cssClass="layout module card" action="confirmmember"
						namespace="/action">
						<button type="submit" class="btn btn-lg btn-primary delete">Confirm</button>
						<div class="information">
							<h4>
								Username:&nbsp;<%=vip.getUsername()%></h4>
							<input type="text" type="text" style="display: none;"
								value=<%=vip.getUsername()%> name="username">
						</div>
						<div class="information">
							<h4>Name:</h4>
							<input type="text" class="form-control" value=<%=vip.getName()%>
								name="name">
						</div>
						<div class="information">
							<h4>Gender:&nbsp;</h4>
							<div class="form-register-gender">
								<input type="radio" name="gender" value="male" name="gender" />&nbsp;
								&nbsp;Male
							</div>
							<div class="form-register-gender">
								<input type="radio" name="gender" value="female" name="gender" />&nbsp;
								&nbsp;Female
							</div>
						</div>
						<br>
						<div class="information">
							<h4>Cellphone:&nbsp;</h4>
							<input type="text" class="form-control"
								value=<%=vip.getPhone().getNo()%> name="phone">
						</div>
						<div class="information">
							<h4>Age:&nbsp;</h4>
							<input type="text" class="form-control" value=<%=vip.getAge()%>
								name="age">
						</div>
						<div class="information">
							<h4>Address:&nbsp;</h4>
							<input type="text" class="form-control"
								value=<%=vip.getAddress()%> name="address" />
						</div>
						<div class="information">
							<h4>Credit No:&nbsp;</h4>
							<input type="text" class="form-control"
								value=<%=vip.getCreditCard().getCr_no()%> name="cr_no">
						</div>
						<br>
					</s:form>
					<s:div>
						<s:div>
							<h4>
								Cards:
								<s:iterator value="%{#request.vip.cardList}" status="st">
									<s:div cssClass="card">
										<s:iterator value="%{#request.vip.cardList.get(#st.index)}">
											<h5>
												Card No:
												<s:property
													value="%{#request.vip.cardList.get(#st.index).code}" />
											</h5>
											<h5>
												Card Type:
												<s:property
													value="%{#request.vip.cardList.get(#st.index).type}" />
											</h5>
											<h5>
												Activated:
												<s:if
													test="%{#request.vip.cardList.get(#st.index).activated  == true}">
												Already Activated
											</s:if>
												<s:else>
												Not Yet Activated
											</s:else>
											</h5>
											<h5>
												Payed:
												<s:if
													test="%{#request.vip.cardList.get(#st.index).payed == true}">
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