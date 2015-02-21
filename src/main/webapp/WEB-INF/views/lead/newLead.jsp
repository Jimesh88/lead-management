<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Lead</title>
<style type="text/css">
#header{


	position: absolute;
    left: 0;
    top: 0;
    
}

.errors{color: #ff0000;
font-style: italic;}

</style>
</head>
<body>
<div id="div1"></div>
<sf:form modelAttribute="lead" action="lead"  method="post">
<fieldset class="step">
                <legend><b>New Lead</b></legend>
                <p>
                    <label for="firstName">First Name:</label>
                    <input id="firstName" name="firstName" value="${lead.firstName}"/>
                    
                </p>
                <p>
                    <label for="lastName" style="color:red">*Last Name:</label>
                    <input id="lastName" name="lastName" value="${lead.lastName}"/>
                  	<sf:errors path="lastName" cssClass="errors"></sf:errors>
                </p>
                <p>
                    <label for="companyName" style="color:red">*Company Name:</label>
                    <input id="companyName" name="companyName" value="${lead.companyName}"/>
                    <sf:errors path="companyName" cssClass="errors"></sf:errors>
                </p>
               <p>
                    <label for="Email">Email Id:</label>
                    <input id="emailId" name="emailId" value="${lead.emailId}" />
                </p>
                <p>
                	
                    <label for="phoneNo">Phone No:</label>
                    <input id="phoneNo" name="phoneNo" value="${lead.phoneNo}"/>
                   	 <sf:errors path="phoneNo" cssClass="errors"></sf:errors>
                   	 
                </p>
                <p>
                	  
                    <label for="mobileNo">Mobile No:</label>
                    <input id="mobileNo" name="mobileNo" value="${lead.mobileNo}"/>
                    <sf:errors path="mobileNo" cssClass="errors"></sf:errors>
                </p>
                <h3>Address</h3><br/>
                 <p>
                    <label for="addressLine1">Address Line1:</label>
                    <input id="addressLine1" name="addressLine1" value="${lead.addressLine1}"/>
                </p>
                <p>
                    <label for="addressLine2">Address Line2:</label>
                    <input width="100px" id="addressLine2" name="addressLine2" value="${lead.addressLine2}"/>
                </p>
               <p>
                    <label for="city">City:</label>
                    <input id="city" name="city" value="${lead.city}" />
                </p>
                <p>
                    <label for="state">State:</label>
                    <input id="state" name="State" value="${lead.state}"/>
                </p>
                <p>
                	
                    <label for="zip">Zip:</label>
                    <input id="zip" name="zip" value="${lead.zip}"/>
                    <sf:errors path="zip" cssClass="errors"></sf:errors>
                </p>
                <p>
                    <label for="country">Country:</label>
                    <input id="country" name="country" value="${lead.country}"/>
                </p>
                <h3>Other Details</h3>
                <p>
                <label for="">Lead Owner:</label>
                <label>${user.userName}</label>
                </p>
                <p>
                <label for="leadStatus">Lead Status:</label>
               <sf:form modelAttribute="lead"> <sf:select path="leadStatus"  id="status">
                	<c:forEach var="s" items="${status}" varStatus="count">
                	<option value="${s}">${s}</option>
                	</c:forEach>
                	</sf:select></sf:form>
                </p>
                <p>
                
                <label for="leadIndustry">Lead Industry:</label>
               <sf:form modelAttribute="lead"> <sf:select path="leadIndustry">
                	<c:forEach var="s" items="${companies}" varStatus="count">
                	<option value="${s}">${s}</option>
                	</c:forEach>
                </sf:select></sf:form>
                </p>
                <p>
                <label for="leadSource">Lead Source:</label>
               <sf:form modelAttribute="lead"><sf:select path="leadSource">
                	<c:forEach var="s" items="${source}" varStatus="count">
                	<option value="${s}">${s}</option>
                	</c:forEach>
                </sf:select></sf:form>
                </p>
               <p>
                 <label for="notes">Notes:</label>
                <sf:form modelAttribute="lead"> <sf:textarea rows="5" path="notes"></sf:textarea></sf:form>
                </p>
                <p>
               
                <input type="submit" value="submit"/>
                </p>
            </fieldset>

</sf:form>
</body>
</html>