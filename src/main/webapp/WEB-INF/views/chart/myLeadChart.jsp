<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>lead report</title>
</head>
<body>
<form method="get">
<h2>Get Monthly chart</h2>
Enter month: <input type="text" id="month"/>

<input type="button" value="get report" onclick="getOpReport()"/>

</form>
<div id="chart"></div>
</body>
</html>