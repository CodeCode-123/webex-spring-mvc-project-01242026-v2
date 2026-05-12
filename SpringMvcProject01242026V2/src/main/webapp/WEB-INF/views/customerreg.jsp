<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Homeheader -->
<%@ include file="homeheader.jsp" %>
<!-- End of Homeheader -->

<!-- User Registration -->
<link href="${contextPath}/resources/admincss/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<div style="margin-left: 30px; margin-top: 100px;">
	<h2>Customer User Registration</h2>
	<f:form action="save1" method="POST" modelAttribute="users" enctype="multipart/form-data">
		<div class="mb-3">
			<label for="exampleInputEmail" class="form-label">First Name: </label> 
			<f:input path="firstName" placeholder="Enter First Name" required="true" />
		</div>
		<div class="mb-3">
		    <label for="exampleInputEmail" class="form-label">Last Name: </label>
			<f:input path="lastName" placeholder="Enter Last Name" required="true" />
		</div>
		<div class="mb-3">
		    <label for="exampleInputEmail" class="form-label">Country: </label>
			<f:select path="country" required="true">
				<f:option value="">Select Country</f:option>
				<f:option value="IND">India</f:option>
				<f:option value="USA">United States</f:option>
				<f:option value="UK">United Kingdom</f:option>
			</f:select>
		</div>
		<div class="mb-3">
		    <label for="exampleInputEmail" class="form-label">Gender: </label>
			<f:radiobutton path="gender" value="Male"/>Male
			<f:radiobutton path="gender" value="Female"/>Female
		</div>
		<div class="mb-3">
		    <label for="exampleInputEmail" class="form-label">Languages: </label>
			<f:checkbox path="language" value="C"/>C
			<f:checkbox path="language" value="C#"/>C# 
			<f:checkbox path="language" value="Java"/>Java
		</div>
		<div class="mb-3">
		    <label for="exampleInputEmail" class="form-label">Email Id: </label>
			<f:input path="emailId" type="email" required="true" />
		</div>
		<div class="mb-3">
		    <label for="exampleInputEmail" class="form-label">Password: </label>
			<f:password path="password" required="true" />
		</div>
		<div class="mb-3">
		    <label for="exampleInputEmail" class="form-label">Upload Photo: </label>
		    <input type="file" id="imagefile" name="imagefile"/>
		</div>
		<div class="mb-3">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</f:form>
</div>
<!-- End of User Registration -->

<!-- footer -->
<%@ include file="homefooter.jsp" %>
<!-- End of footer -->