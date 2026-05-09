<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Adminheader -->
<%@ include file="adminheader.jsp" %>
<!-- End of Adminheader -->

<!-- Edit Registration -->
	<h1>Edit Registration</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	<!-- form action allows both ../path and ${contextPath}/path -->
	<f:form action="../editsave" method="POST" modelAttribute="users" enctype="multipart/form-data">
	<p><f:hidden path="id"/></p>
		<p>
			First Name: <f:input path="firstName" placeholder="Enter First Name" required="true" />
		</p>
		<p>
			Last Name: <f:input path="lastName" placeholder="Enter Last Name" required="true" />
		</p>
		<p>
			Country: <f:select path="country" required="true">
				<f:option value="">Select Country</f:option>
				<f:option value="IND">India</f:option>
				<f:option value="USA">United States</f:option>
				<f:option value="UK">United Kingdom</f:option>
			</f:select>
		</p>
		<p>
			Gender: <f:radiobutton path="gender" value="Male"/>Male
			<f:radiobutton path="gender" value="Female"/>Female
		</p>
		<p>
			Languages: <f:checkbox path="language" value="C"/>C
			<f:checkbox path="language" value="C#"/>C# 
			<f:checkbox path="language" value="Java"/>Java
		</p>
		<p>Upload Photo: <input type="file" id="imagefile" name="imagefile"/></p>
		<p>
			<button type="submit">Submit</button>
		</p>
	</f:form>
<!-- End of Edit Registration -->

<!-- Footer -->
<%@ include file="footer.jsp" %>
<!-- End of Footer -->