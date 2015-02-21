<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


<script type="text/javascript">

$(document).ready(function(){
//open popup
$("#pop").click(function(){
$("#overlay_form").fadeIn(300);
positionPopup();
});
 
//close popup
$("#close").click(function(){
$("#overlay_form").fadeOut(400);
});
});
 
//position the popup at the center of the page
function positionPopup(){
if(!$("#overlay_form").is(':visible')){
return;
}
$("#overlay_form").css({
left: ($(window).width() - $('#overlay_form').width()) / 2,
top: ($(window).width() - $('#overlay_form').width()) / 7,
position:'absolute'
});
}
 
//maintain the popup at center of the page when browser resized
$(window).bind('resize',positionPopup);
 

</script>
<style type="text/css">
#logout{
	display:none;
}
#overlay_form{
position: relative;
border: 5px solid gray;
padding: 10px;
background: white;
width: 300px;
height: 250px;
margin-top: 0;
}
#pop{
display: block;
border: 1px solid gray;
width: 65px;
text-align: center;
border-radius: 5px;
text-decoration: none;
margin-top: 30%;
}
#footer{
	position: relative;
   
   
    margin-top:39%;
    height:47px;
}
#header{

box-shadow: 2px 6px 14px 	#7A8B8B;
	position: absolute;
    left: 0;
    top: 0;
    

}
#login-error{z-index: 4}
#login{
     position:absolute;
     width:300px;
     height:300px;
     top:50%;
     left:50%;
     margin:-150px 0 0 -150px;
     background:#C1CDCD;
}
.table tr{padding-bottom: 30px;}
.table {margin-top:90px;}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login form</title>


</head>
<body>
	<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
				
				<div id="login" >
					<form action="login" method="post">
						<table class="table">
						<tr >
						<td>UserName:</td>
						<td><input type="text" name="userName" /></td>
						</tr>
						<tr>
						<td>Password:</td>
						<td><input type="password" name="password" /></td>
						</tr>
						<tr>
						<td>
						<input type="submit" value="login"/>
						</td>
						</tr><tr>
						<td><a href="#" id="pop">Register</a></td>
						</tr>
						<tr>
						<td><div id="login-error" style="color:red">${error}</div></td>
						<td><div id="login-err" style="color:red">${err}</div></td>
						</tr>
					</table>
					</form>
				</div>
				
				
	<div id="register"><jsp:include page="user/registerUser.jsp"></jsp:include></div>
	
	<div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
			
</body>
</html>