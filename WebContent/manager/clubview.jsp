<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="health club login page" />
<meta name="author" content="zhang xu fan" />
<link rel="shortcut icon"
	href="<s:url value="/material/logo.ico"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/bootstrap.css"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/customize.css"></s:url>" />
<link rel="stylesheet"
	href="<s:url value="/css/bootstrap-theme.min.css"></s:url>" />
<title>Club Statistics</title>
<%int[][] card = (int[][])request.getAttribute("card"); %>
<script type="text/javascript"
	src="<s:url value="/js/jquery-1.11.0.js"></s:url>"></script>
		<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        data: {
            table: document.getElementById('datatable')
        },
        chart: {
            type: 'column'
        },
        title: {
            text: 'VIP Card Usage'
        },
        yAxis: {
            allowDecimals: false,
            title: {
                text: 'Units'
            }
        },
        tooltip: {
            formatter: function() {
                return '<b>'+ this.series.name +'</b><br/>'+
                    this.point.y +' '+ this.point.name.toLowerCase();
            }
        }
    });
});
		</script>
	</head>
	<body>
		<script src="<s:url value="/js/highcharts.js"></s:url>"></script>
	<script src="<s:url value="/js/modules/exporting.js"></s:url>"></script>
	<script src="<s:url value="/js/modules/data.js"></s:url>"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

<table id="datatable">
	<thead>
		<tr>
			<th></th>
			<th>Normal</th>
			<th>Unnormal</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>Card</th>
			<td><%=card[0][0] %></td>
			<td><%=card[0][1] %></td>
		</tr>
		<tr>
			<th>Activated</th>
			<td><%=card[1][0] %></td>
			<td><%=card[1][1] %></td>
		</tr>
		<tr>
			<th>Payed</th>
			<td><%=card[2][0] %></td>
			<td><%=card[2][1] %></td>
		</tr>
	</tbody>
</table>
	</body>
</html>
