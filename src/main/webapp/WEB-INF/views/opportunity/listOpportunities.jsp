<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result page</title>
 

</head>
<body>

	<div><a href="opportunity" id="newopp">Add new opportunity</a></div>
	<div><a href="chart">Chart report</a></div>
<h3>List of Opportunities</h3>
<table class="opportunityTable" border="1" cellspacing="2">
	<tr>
	
	
		<th>Name</th>
		<th>Owner</th>
		<th>Account</th>
		<th>ClosingDate</th>
		<th>Delete</th>
		<th>Edit</th>
	</tr>
	<c:forEach items="${opportunities}" var="o" varStatus="count" >
		<tr id="tro+${o.opportunityId}">
		<td>${o.name}</td>
		<td>${user.userName}</td>
		<td>${o.account.accountName}</td>
		<td>${o.closingDate}</td>
    	<td><sf:form id="fm" action="opportunity/${o.opportunityId}" method="delete" class="form"><input type="submit" value="delete" class="del"/></sf:form></td>
		
		
<%--   	<td><input type="button" value="delete" onclick="deleterecord('${o.opportunityId}')"/></td>
 --%> 
		<td><a href="opportunity/${o.opportunityId}">edit</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>