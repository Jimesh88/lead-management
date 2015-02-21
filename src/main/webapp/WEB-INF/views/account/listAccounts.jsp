<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>


 <a href="account" id="newaccount">Add new Account</a></div>
	<h3>List of Accounts</h3>
<table class="accountTable" border="1" cellspacing="2">
	<tr>
		<th>Account Name</th>
		<th>Account Owner</th>
		<th>Account Type</th>
		<th>Account Rating</th>
		<th>Delete</th>
		<th>Edit</th>
		
	</tr>
	<c:forEach items="${accounts}" var="account">
		<tr id="${account.accountId}">
		<td>${account.accountName}</td>
		<td>${user.userName}</td>
		<td>${account.accountType}</td>
		<td>${account.accountRating}</td>
		<td><input type="button" value="delete" onclick="delAccount('${account.accountId}')"/></td>
		<td><a href="account/${account.accountId}">edit</a>
	</tr>
	</c:forEach>	
</table>
</body>
</html>