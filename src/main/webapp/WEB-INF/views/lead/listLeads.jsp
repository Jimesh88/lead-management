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
<div>
	
 <a href="lead" id="newlead">Add new lead</a></div>
			
<h3>List of Leads</h3>

<table class="leadTable" border="1" cellspacing="2">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Phone No</th>
		<th>CompanyName</th>
		<th>Lead Status</th>
		<th>Delete</th>
		<th>Edit</th>
	</tr>
	<c:forEach items="${leads}" var="lead">
		<tr id="${lead.leadId}">
		<td>${lead.firstName}</td>
		<td>${lead.lastName}</td>
		<td>${lead.phoneNo}</td>
		<td>${lead.companyName}</td>
		<td>${lead.leadStatus}</td>
		<td><input  type="button" value="delete" onclick="deleteLead('${lead.leadId}')"/></td>
		<td><a href="lead/${lead.leadId}">edit</a></td>
	</tr>
	</c:forEach>

	
</table>

</body>
</html>