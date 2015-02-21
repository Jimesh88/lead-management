 
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
				alert("hi");
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



