<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit opportunity</title>
<link rel="stylesheet"
	href="http://code.jquery.
	com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/css/style.css" />
<style type="text/css">
.errors{color: #ff0000;
font-style: italic;}

</style>
<script>
$(function() {
	$( "#closingDate" ).datepicker();
	});

</script>
</head>
<body>
	<body>
	<div id="div4">
		<sf:form modelAttribute="opportunity" method="post">
			<fieldset class="step">
				<legend>edit opportunity</legend>
				<p>
					<label for="name" style="color:red">*Opportunity Name:</label> 
					
					<sf:input path="name"
						 value="${opportunity.name}" />
						<sf:errors path="name" cssClass="errors"></sf:errors>
				</p>
				<p>
					<label for="owner">Owner:</label>  <label>${user.userName}</label>
				</p>

				<p>
					<label for="accountname" style="color:red">*Account:</label> 
					 <select
						name="accountname" id="account">
						<c:forEach var="account" items="${accounts}" varStatus="count">
							<option value="${account.accountId}">${account.accountName}</option>
						</c:forEach>
					</select>

				</p>
				<p>
					<label for="closingDate" style="color:red">Closing Date:</label> <sf:input
						 type="text" path="closingDate"
						value="${opportunity.closingDate}" />
						<sf:errors path="closingDate" cssClass="errors"></sf:errors>
						
				</p>
				<p>
					<label for="expectedRevenue" style="color:red">*Revenue:</label> <sf:input
						id="expectedRevenue" path="expectedRevenue"
						value="${opportunity.expectedRevenue}" />
						<sf:errors path="expectedRevenue" cssClass="errors"></sf:errors>
				</p>
				<p>
					<label for="stage" style="color:red">*Stage:</label> <sf:select path="stage">
						<c:forEach var="stage" items="${stages}" varStatus="count">
							<option value="${stage}">${stage}</option>
						</c:forEach>
					</sf:select>
				</p>
				<p>
					<label for="reason">Loss reason:</label> <sf:input 
						path="reason" value="${opportunity.reason}" />
						<sf:errors path="reason" cssClass="errors"></sf:errors>
				</p>
				<p>
					<label for="notes">Notes:</label>
					<sf:form modelAttribute="opportunity"><sf:textarea path="notes" rows="5" name="mytext"></sf:textarea></sf:form>
				</p>
				<p>
				<input type="hidden" name="index" value="3">
					<input type="submit" value="update" />
				</p>



			</fieldset>



		</sf:form>


	</div>
</body>
</html>