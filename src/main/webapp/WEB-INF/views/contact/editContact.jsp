<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit contact</title>
</head>
<body>
<div id="div3">
<sf:form method="post">
	 <fieldset class="step">
	 <legend>Edit Contact</legend>
	 			<p>
	 			 <label for="accountname" style="color:red">*Account:</label>
	 			<select name="accountname" id="account">
                	<c:forEach var="account" items="${accounts}" varStatus="count">
                	<option value="${account.accountId}">${account.accountName}</option>
                	</c:forEach>
                	</select>
	 			
	 			</p>
	            <p>
      	            <label for="firstName">First Name:</label>
                    <input id="firstName" name="firstName" value="${contact.firstName}"/>
                </p>
                <p>
                    <label for="lastName" style="color:red">*Last Name:</label>
                    <input id="lastName" name="lastName" value="${contact.lastName}"/>
                    <sf:errors path="lastName" cssClass="errors"></sf:errors>
                </p>
                <p>
                    <label for="title">Title:</label>
                    <input id="title" name="title" value="${contact.title}"/>
                </p>
               <p>
                    <label for="emailId">Email Id:</label>
                    <input id="emailId" name="emailId" value="${contact.emailId}" />
                </p>
                <p>
                    <label for="officeNo">Office Phone No:</label>
                    <input id="officeNo" name="officeNo" value="${contact.officeNo}"/>
                    <sf:errors path="officeNo" cssClass="errors"></sf:errors>
                </p>
	 			<p>
                    <label for="mobileNo">Mobile No:</label>
                    <input id="mobileNo" name="mobileNo" value="${contact.mobileNo}"/>
                    <sf:errors path="mobileNo" cssClass="errors"></sf:errors>
                </p>
                <h3>Address</h3>
               <p>
                    <label for="addressLine1">Address Line1:</label>
                    <input id="addressLine1" name="addressLine1" value="${contact.addressLine1}" />
                </p>
                <p>
                    <label for="addressLine2">Address Line2</label>
                    <input id="addressLine2" name="addressLine2" value="${contact.addressLine2}"/>
                </p>
                <p>
                    <label for="city">City:</label>
                    <input id="city" name="city" value="${contact.city}" />
                </p>
                <p>
                    <label for="state">State</label>
                    <input id="state" name="state" value="${contact.state}"/>
                </p>
                 <p>
                    <label for="zip">Zip:</label>
                    <input id="zip" name="zip" value="${contact.zip}" />
                    <sf:errors path="zip" cssClass="errors"></sf:errors>
                </p>
                <p>
                    <label for="country">State</label>
                    <input id="country" name="country" value="${contact.country}"/>
                </p>
                 <p>
                <label for="">Owner:</label>
                <label>${user.userName}</label>
                </p>
	 			<p>
                 <label for="notes">Notes:</label>
                <sf:form modelAttribute="contact"><sf:textarea rows="5" path="notes" name="mytext"></sf:textarea></sf:form> 
                </p>
                <p>
                <input type="hidden" name="index" value="2">
                <input type="submit" value="update"/>
                </p>
	 
	 </fieldset>


</sf:form>


</div>

</body>
</html>