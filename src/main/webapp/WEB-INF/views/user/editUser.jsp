<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit user</title>
</head>
<body>
<form method="post">
	<fieldset class="step">
			<legend>Edit User</legend>
			<p>
			<label for="userName">UserName</label>
			<input name="userName" value="${user.userName}"/>
			</p>
			<p>
			<label for="roleName">Role</label>
			<select name="roleName" id="status">
						<option value="1">Admin</option>
						<option value="2">Normal</option>
						<option value="3">Guest</option>		
			
			</select>
			</p>
			<p>
			<input type="hidden" name="password" value="${user.password}"/>
			</p>
			<p>
			<input type="hidden" name="confirmPassword" value="${user.confirmPassword}"/>
			</p>
			<p>
			<label for="status">Status</label>
			<select name="status" id="status">
						<option value="Approved">Approved</option>
						<option value="Pending">Pending</option></select>
			</p>
			<p>
			<label for="Department">Department</label>
			<select name="department" id="department">
						<option value="Sales">Sales</option>
						<option value="Marketing">Marketing</option>
						<option value="Support">Support</option>
						<option value="Engineer">Engineer</option>
						<option value="Administration">Administration</option>
					</select>
			</p>
			<p>
			  <input type="hidden" name="index" value="0">
                <input type="submit" value="update"/>
			</p>
     </fieldset>
		
	



</form>

</body>
</html>