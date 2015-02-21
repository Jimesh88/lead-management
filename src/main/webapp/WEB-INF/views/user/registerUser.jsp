<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<style type="text/css">
#er {color:red;
font-style: italic;}

</style>
<script type="text/javascript">

$("#close").click(function(){
	$("#userName").val('');
	$("#password").val('');
	$("confirmPassword").val('');
	
	
});



	function addUser()
	{
		var rootUrl ="http://localhost:8080/finalproject/register";
		var userName= $("#userName").val();
		var password = $("#password").val();
		var confirmPassword= $("#confirmPassword").val();
		var department =$("#department").val();
		
		var dataString = 'userName='+userName+'&password='+password+'&confirmPassword='+confirmPassword+'&department='+department;
		var i;
		 $.ajax({
				async:"true",
				url: rootUrl,
		 		type:'POST',
		 		data:dataString,
		 		success:function(response){
		 			if(response.status=="Success")
		 				{
		 				alert('Registered successfuly');
		 				
		 				}
		 			else if(response.status=="userExist")
		 				{
		 				alert('user already exist');
		 				}
		 			else 
		 				{
		 				
		 					var errorInfo="";
		 					for( i = 0;i<response.result.length;i++)
		 						{
		 							errorInfo+="<br>" + (i + 1) +". " + response.result[i].code;
		 						
		 						}
		 	                 $('#er').html("Please correct following errors: " + errorInfo);
		 					
		 				};
		 		},
			 	error:function(error){
			 		
			 		alert(error.message);
			 	},
				 
				 
			 });
		
	}
	

</script>

</head>
<body>
		
	<sf:form id="overlay_form" style="display:none" commandName="user" action="register" method="post" >
	
		<table cellspacing="4">
			
			<tr>
				<td>User Name:</td>
				<td><input id="userName" name="userName" value="${user.userName}"/></td>
			</tr> 
			<tr>
				<td>Password:</td>
				<td><input id="password" type="password" name="password" value="${user.password}"/></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input id="confirmPassword" type="password" name="confirmPassword" value="${user.confirmPassword}"/></td>
			<tr>
			 <tr>
				<td>Department</td>
				<td><select 
						name="department" id="department">
						<option value="Sales">Sales</option>
						<option value="Marketing">Marketing</option>
						<option value="Support">Support</option>
						<option value="Engineer">Engineer</option>
						<option value="Administration">Administration</option>
					</select>
			</tr> 
			<tr>
				<td colspan="2"><input type="button" id="sub" value="register" onclick="addUser()"></td>
				<td colspan="2"><a href="#" id="close" >Close</a></td>
			</tr>
			
			
			
	
		</table>
		<div id="er"></div>
	</sf:form>
	
</body>
</html>