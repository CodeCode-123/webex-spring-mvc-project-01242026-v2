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

	<form action="save" method="POST">
		<p>
			First Name: <input type="text" name="first-name" id="first-name"
				placeholder="Enter First Name" required>
		</p>
		<p>
			Last Name: <input type="text" name="last-name" id="last-name"
				placeholder="Enter Last Name" required>
		</p>
		<p>
			Country: <select name="country" id="country" required>
				<option value="">Select Country</option>
				<option value="IND">India</option>
				<option value="USA">United States</option>
				<option value="UK">United Kingdom</option>
			</select>
		</p>
		<p>
			Gender: <input type="radio" name="gender" id="gender" value="Male"/>Male
			<input type="radio" name="gender" id="gender" value="Female"/>Female
		</p>
		<p>
			Languages: <input type="checkbox" id="lang1" name="lang1" value="C"/>C
			<input type="checkbox" id="lang2" name="lang2" value="C#"/>C# 
			<input type="checkbox" id="lang3" name="lang3" value="Java"/>Java
		</p>
		<p>
			Email Id: <input type="email" name="email-id" id="email-id" required />
		</p>
		<p>
			Password: <input type="password" name="password" id="password"
				required />
		</p>
		<p>
			<button type="submit">Submit</button>
		</p>
	</form>

</body>
</html>