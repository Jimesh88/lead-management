<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>get report</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript">
function getOpReport(){
	var url="http://localhost:8080/finalproject/chart/opp";
	var month=$("#month").val();
	 $.ajax({
			async:"true",
			url: url + "/"+month,
	 		type:'GET',
	 		
	 		dataType:"text",
	 		success:function(response){
	 			$("#chart").html("<img src="+response+" />");
	 		},
		 	error:function(error){
		 		if(error.status=='500')
		 		alert("no records found");
		 	},
			  
		 });
	
	
}


</script>
</head>
<body>
<h2>Monthly chart report</h2>
<form method="get">

Enter month: <input type="text" id="month"/>

<input type="button" value="get report" onclick="getOpReport()"/>

</form>
<div id="chart"></div>
</body>
</html>