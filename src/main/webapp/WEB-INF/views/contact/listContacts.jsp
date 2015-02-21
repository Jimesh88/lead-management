<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>

<script type="text/javascript">


</script>
</head>
<body>
<div><a href="contact" id="newContact">Add new Contact</a></div>
			
<h3>List of contacts</h3>
<table class="contactTable" border="1" cellspacing="2">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Mobile No</th>
		<th>Title</th>
		<th>Email id</th>
		<th>delete</th>
		<th>Edit</th>
		
	</tr>
	<c:forEach items="${contacts}"  var="contact">
		<tr id="${contact.contactId}">
		<td>${contact.firstName}</td>
		<td>${contact.lastName}</td>
		<td>${contact.mobileNo}</td>
		<td>${contact.title}</td>
		<td>${contact.emailId}</td>
		<td><input type="button" value="delete" onclick="deleteContact('${contact.contactId}')"/></td>
		<td><a href="contact/${contact.contactId}">edit</a></td>
	</tr>
	</c:forEach>

	
</table>

</body>
</html>