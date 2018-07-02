<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
</head>
<body>
<h1>Students Data</h1>
<br>

<table border="1">
	<th>ticker</th>
	<th>date</th>
	<th>Open</th>
	<th>Close</th>
	<c:forEach items="${allhistdata}" var="histdata">
		<tr>
			<td>${histdata.histPK.ticker}</td>
			<td>${histdata.histPK.tradeDate}</td>
			<td>${histdata.open}</td>
			<td>${histdata.close}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>