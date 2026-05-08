<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="en">
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Login</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    

<!-- Bootstrap core CSS -->
<link href="${contextPath }/resources/admincss/css/bootstrap.min.css" rel="stylesheet"/>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
<!-- Custom styles for this template -->
<link href="${contextPath }/resources/signin.css" rel="stylesheet"/>
</head>
<body class="text-center">
<main class="form-signin">
	<form action="authentication" method="POST">
		<h1 class="h3 mb-3 fw-normal">User Login</h1>
		<div class="form-floating">
		  <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter User Name"/>
          <label for="floatingInput">User Name</label>		
		</div>
		<div class="form-floating">
		  <input type="password" class="form-control" id="upass" name="upass" placeholder="Password"/>
		  <label for="floatingPassword">Password</label>
		</div>
		<div class="checkbox mb-3">
		  <label>
		    <input type="checkbox" value="remember-me"/>Remember me
		  </label>		
		</div>
		<div class="checkbox mb-3">
		  <label>
		    ${errmsg }
		  </label>
		</div>
		<div class="checkbox mb-3">
		  <a href="users/registration">New User Sign Up</a>
		  <button class="w-100 btn btn-lg btn-primary">Sign In</button>
		</div>
	</form>
</main>
</body>
</html>