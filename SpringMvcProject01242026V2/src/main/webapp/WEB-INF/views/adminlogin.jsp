<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/style.css"/>
</head>
<body>
	<h1>Login</h1>
	<form action="authentication" method="POST">
		<table cellpadding="10" border="1" cellspacing="0">
			<tr>
				<th>User Name</th>
				<td>
				  <input type="text" id="uname" name="uname" placeholder="Enter User Name" required />
				</td>
			</tr>
			<tr>
				<th>Password</th>
				<td class="login">
				  <input type="password" id="upass" name="upass" placeholder="Enter Password" required />
				</td>
			</tr>
			<tr>
			    <td colspan="2">
			      <div class="err">${errmsg}</div>
			    </td>
			</tr>
			<tr>
			    <th colspan="2">
			      <button type="submit">Login</button>
			    </th>
			</tr>
		</table>
	</form>

</body>
</html>