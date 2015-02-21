<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Edit account</h2>
<div id="div2">
		<sf:form method="post">
			<fieldset class="step">
				<legend>
					<b>edit Account</b>
				</legend>
				<p>
					<label for="accountName" style="color: red">*Account Name:</label>
					<input id="accountName" name="accountName"
						value="${account.accountName}" />
					<sf:errors path="accountName" cssClass="errors" />
				</p>
				<p>
					<label for="accountType">Account Type:</label>
					<sf:form modelAttribute="account">
						<sf:select path="accountType" id="accountType">
							<c:forEach var="at" items="${types}" varStatus="count">
								<option value="${at}">${at}</option>
							</c:forEach>

						</sf:select>
					</sf:form>
				</p>

				<p>
					<label for="">Lead source:</label> <select name="leadname">
						<option value="">no lead</option>
						<c:forEach var="r" items="${leads}" varStatus="count">

							<option value="${r.leadId}">"${r.companyName}"</option>

						</c:forEach>


					</select>
				</p>
				<p>
					<label for="accountRating">Account Rating:</label>
					
						<select name="accountRating" id="accountRating">
							<c:forEach var="r" items="${ratings}" varStatus="count">
								<option value="${r}">${r}</option>
							</c:forEach>

						</select>
					
				</p>

				<p>
					<label for="accountIndustry">Account Industry:</label>
					<sf:form modelAttribute="account">
						<sf:select path="accountIndustry">
							<c:forEach var="c" items="${companies}" varStatus="count">
								<option value="${c}">${c}</option>
							</c:forEach>
						</sf:select>
					</sf:form>
				</p>
				<p>
					<label for="numberOfEmployees">No of employees:</label> <input
						id="noOfEmployees" name="numberOfEmployees"
						value="${account.numberOfEmployees}" />
					<sf:errors path="numberOfEmployees" cssClass="errors" />
				</p>
				<p>
					<label for="phoneNo">Phone No:</label> <input id="phoneNo"
						name="phoneNo" value="${account.phoneNo}" />
					<sf:errors path="phoneNo" cssClass="errors" />
				</p>
				<p>
					<label for="annualRevenue">Annual Revenue:</label> <input
						id="annualRevenue" name="annualRevenue"
						value="${account.annualRevenue}" />
					<sf:errors path="annualRevenue" cssClass="errors" />
				</p>
				<p>
					<label for="fax">Fax:</label> <input id="fax" name="fax"
						value="${account.fax}" />
					<sf:errors path="fax" cssClass="errors" />
				</p>

				<p>
					<label for="website">Website:</label> <input id="website"
						name="website" value="${account.website}" />
				</p>
				<h4>Billing Address</h4>
				<br />
				<p>
					<label for="billingAddressLine1">Billing Address Line1:</label> <input
						id="billingAddressLine1" name="billingAddressLine1"
						value="${account.billingAddressLine1}" />
				</p>
				<p>
					<label for="billingAddressLine2">Billing Address Line2:</label> <input
						width="100px" id="billingAddressLine2" name="billingAddressLine2"
						value="${account.billingAddressLine2}" />
				</p>
				<p>
					<label for="billingCity">Billing City:</label> <input
						id="billingCity" name="billingCity" value="${account.billingCity}" />
				</p>
				<p>
					<label for="billingState">Billing State:</label> <input
						id="billingState" name="billingState"
						value="${account.billingState}" />
				</p>
				<p>
					<label for="billingZip">Billing Zip:</label> <input id="billingZip"
						name="billingZip" value="${account.billingZip}" />
					<sf:errors path="billingZip" cssClass="errors" />
				</p>
				<p>
					<label for="billingCountry">Billing Country:</label> <input
						id="billingCountry" name="billingCountry"
						value="${account.billingCountry}" />
				</p>
				<h4>Shipping Address</h4>
				<br />
				<p>
					<label for="shippingAddressLine1">Shipping Address Line1:</label> <input
						id="shippingAddressLine1" name="shippingAddressLine1"
						value="${account.shippingAddressLine1}" />
				</p>
				<p>
					<label for="shippingAddressLine2">Shipping Address Line2:</label> <input
						width="100px" id="shippingAddressLine2"
						name="shippingAddressLine2"
						value="${account.shippingAddressLine2}" />
				</p>
				<p>
					<label for="shippingCity">Shipping City:</label> <input
						id="shippingCity" name="shippingCity"
						value="${account.shippingCity}" />
				</p>
				<p>
					<label for="shippingState">Shipping State:</label> <input
						id="shippingState" name="shippingState"
						value="${account.shippingState}" />
				</p>
				<p>
					<label for="shippingZip">Shipping Zip:</label> <input
						id="shippingZip" name="shippingZip" value="${account.shippingZip}" />
					<sf:errors path="shippingZip" cssClass="errors" />
				</p>
				<p>
					<label for="shippingCountry">Shipping Country:</label> <input
						id="shippingCountry" name="shippingCountry"
						value="${account.billingCountry}" />
				</p>
				<p>
					<label for="notes">Notes:</label>
					<textarea rows="5" name="mytext"></textarea>
				</p>
				<p>
					<input type="hidden" name="index" value="1"> <input
						type="submit" value="update" />
				</p>


			</fieldset>


		</sf:form>


	</div>
</body>
</html>