<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

#tabs{
		 margin-top:6%;
		 width:100%;
		 left:0;
	
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result page</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>



<style type="text/css">
#logout{
	visiblity:visible;
}

#header{

box-shadow: 2px 6px 14px 	#7A8B8B;
	position: absolute;
    left: 0;
    top: 0;
    

}
</style>
 
 <script type="text/javascript">
 
 var rootUrlOp="http://localhost:8080/finalproject/opportunity/del";
 var rootAccUrl="http://localhost:8080/finalproject/account/del";
var rootLeadUrl="http://localhost:8080/finalproject/lead/del";
var rootContUrl="http://localhost:8080/finalproject/contact/del";
var rootUserUrl="http://localhost:8080/finalproject/user/del";


 $(function() {
	
	 $( "#tabs" ).tabs({ active: document.tabTest.mypageid.value});
	 
	 $('#tabs a').click(function(e) {
         var curTab = $('.ui-tabs-active');
         curTabIndex = curTab.index();
         document.tabTest.currentTab.value = curTabIndex;
     });
	 
	 });
 
 function deleteContact(id){
		
		
	 $.ajax({
		async:"true",
		url: rootContUrl + "/"+id,
		type:'POST',
		data: {"_method":"delete"},
		dataType:"text",
		success:function(response){
			$('#'+id).fadeOut(400);
		},
	 	error:function(error){
	 		
	 		alert(error.message);
	 	},
		 
		 
	 });
}


 function deleterecord(id){
		
	 $.ajax({
		async:"true",
		url: rootUrlOp + "/"+id,
 		type:'POST',
 		data: {"_method":"delete"},
 		dataType:"text",
 		success:function(response){
 			$('#tro'+id).fadeOut(400);
 		},
	 	error:function(error){
	 		
	 		alert(error.message);
	 	},
		  
	 });
}
	
function delAccount(id){
	
	
	 $.ajax({
		async:"true",
		url: rootAccUrl + "/"+id,
		type:'POST',
		data: {"_method":"delete"},
		dataType:"text",
		success:function(response){
			if(response=="successfully deleted")
			{
				
				$('#'+id).fadeOut('fast');
			}
			else 
				{
				alert("cannot delete account. make sure there are no contacts or opportunities related to this account");
			}
		},
	 	error:function(error){
	 		
	 		alert(error.message);
	 	},
		 
		 
	 });
}

function deleteLead(id){
	
	
	 $.ajax({
		async:"true",
		url: rootLeadUrl + "/"+id,
		type:'POST',
		data: {"_method":"delete"},
		dataType:"text",
		success:function(response){
			
			$('#'+id).fadeOut('fast');
		},
	 	error:function(error){
	 		
	 		alert(error.message);
	 	},
		 
		 
	 });
}
	
	
	
 
    </script>

</head>
<body><!-- onload="getSelectedIndex()" -->
	 <div id="header"><jsp:include page="header.jsp"></jsp:include></div> 
	 <form name="tabTest"  method="post" action="tab">
 <input type="hidden" name="mypageid" value="0"/>
	 <div id="tabs">
		<ul id="nav">
			<li><a href="#tabs-1">Lead</a></li>
			<li><a href="#tabs-2">Account</a></li>
			<li><a href="#tabs-3">Contact</a></li>
			<li><a href="#tabs-4">Opportunity</a></li>
			
			
			
		</ul>
		
		<div id="tabs-1">
			<p><jsp:include page="lead/listLeads.jsp"></jsp:include></p> 
		</div>
		<div id="tabs-2">
			<p><jsp:include page="account/listAccounts.jsp"></jsp:include></p>
			
		</div>
		<div id="tabs-3">
			<p><jsp:include page="contact/listContacts.jsp"></jsp:include></p>
			
		</div>
		<div id="tabs-4">
			<p><jsp:include page="opportunity/listOpportunities.jsp"></jsp:include></p>
		</div>
		
		
	</div>
	</form>
</body>
</html>