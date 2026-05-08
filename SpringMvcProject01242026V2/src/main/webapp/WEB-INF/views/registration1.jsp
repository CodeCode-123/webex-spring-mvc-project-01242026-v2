<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Adminheader -->
<%@ include file="adminheader.jsp" %>
<!-- End of Adminheader -->

<!-- User Registration -->
	<h2>Admin User Registration</h2>

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
<!-- End of User Registration -->

<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- End of footer -->