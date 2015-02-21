<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-1.4.min.js"></script>
<script type="text/javascript" src="json.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

function deleteUser(id){
	//var url = rootUserUrl + "/"+id;
	/* $.getJSON(url, function(data) {
		//alert("Success");
		$('#tr'+id).hide("slow");
		
		}); */
	
	 $.ajax({
 		async:"false",
 		url: rootUserUrl + "/"+id,
 		type:'POST',
 		data: {"_method":"delete"},
 		dataType:"text",
 		success:function(response){
			
 			$('#tr'+id).fadeOut(200);
 		},
 	 	error:function(error){
 	 		if(error.status=="500")
 	 		alert("cannot delete user.make sure all the references are deleted");
 	 	},
		 
		 
	 });
}
</script>
</head>
<body>
<div>${error}</div>
<table border=1 cellspacing="2">
	<tr>
		<th>UserName</th>
		<th>Department</th>
		<th>Role</th>
		<th>Status</th>
		<th>Delete</th>
		<th>Edit</th>
	</tr>	
	<c:forEach items="${users}" var="user">
		<tr id="tr+${user.userId}">
		<td>${user.userName}</td>
		<td>${user.department}</td>
		<td>${user.role.roleName}</td>
		<td>${user.status}</td>
		
<td><sf:form id="fm" action="user/${user.userId}" method="delete" class="form"><input type="submit" value="delete" class="del"/></sf:form></td>
		
		
<%-- 		<td><input type="button" value="delete" onclick="deleteUser('${user.userId}')"/></td>
 --%>		<td><a href="user/${user.userId}">edit</a></td>
		</tr>
	
	
	</c:forEach>

</table>

</body>
</html>