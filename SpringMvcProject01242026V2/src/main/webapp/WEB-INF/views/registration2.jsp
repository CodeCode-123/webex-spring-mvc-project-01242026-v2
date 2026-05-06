<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
	<h1>User Registration</h1>

	<f:form action="save1" method="POST" modelAttribute="users">
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
		<p>
			Email Id: <f:input path="emailId" type="email" required="true" />
		</p>
		<p>
			Password: <f:password path="password" required="true" />
		</p>
		<p>
			<button type="submit">Submit</button>
		</p>
	</f:form>

</body>
</html>