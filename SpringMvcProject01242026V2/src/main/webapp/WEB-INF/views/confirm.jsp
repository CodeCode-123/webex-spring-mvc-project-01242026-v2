<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Please Confirm</h1>
<p>Name: ${users.firstName} ${users.lastName}</p>
<p>Gender: ${users.gender}</p>
<p>Country: ${users.country}</p>
<c:set var="languages" value="${fn:join(users.language, ', ')}" />
<p>Languages: ${languages}</p>
</body>
</html>