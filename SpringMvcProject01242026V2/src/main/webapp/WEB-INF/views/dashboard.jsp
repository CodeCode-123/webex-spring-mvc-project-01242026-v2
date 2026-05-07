<!-- adminheader -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="generator" content="Hugo 0.84.0">
<title>Dashboard</title>

<!-- Bootstrap core CSS -->
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

<!-- Custom styles for this template -->
<link href="${contextPath}/resources/dashboard.css" rel="stylesheet"/>
</head>

<body>
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Welcome ${uname}</a>
<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
			</button>
<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search"/>
<div class="navbar-nav">
  <div class="nav-item text-nowrap">
    <a class="nav-link px-3" href="${contextPath}/admin/logout">Sign out</a>
  </div>
</div>
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <div class="position-sticky pt-3">
      <ul class="nav flex-column">
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#">
          <span data-feather="home"></span>Dashboard</a></li>
        <li class="nav-item"><a class="nav-link" href="#">
          <span data-feather="file"></span>Orders</a></li>
        <li class="nav-item"><a class="nav-link" href="#"><span data-feather="shopping-cart"></span>Categories</a></li>
        <li class="nav-item"><a class="nav-link" href="#"><span data-feather="shopping-cart"></span>Products</a></li>
        <li class="nav-item"><a class="nav-link" href="#"><span data-feather="users"></span>Customers</a></li>
        <li class="nav-item"><a class="nav-link" href="#"><span data-feather="users"></span>Users</a></li>
        <li class="nav-item"><a class="nav-link" href="#"><span data-feather="bar-chart-2"></span>Reports</a></li>
        <li class="nav-item"><a class="nav-link" href="#"><span data-feather="layers"></span>Integrations</a></li>
      </ul>
      <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
        <span>Saved reports</span><a class="link-secondary" href="#" aria-label="Add a new report">
          <span data-feather="plus-circle"></span></a></h6>
    <ul class="nav flex-column mb-2">
      <li class="nav-item"><a class="nav-link" href="#"><span data-feather="file-text"></span>Current month</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><span data-feather="file-text"></span>Last quarter</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><span data-feather="file-text"></span>Social engagement</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><span data-feather="file-text"></span>Year-end sale</a></li>
    </ul>
    </div>
    </nav>
    
    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <br>
<!-- End of adminheader -->
      
<!-- Dashboard -->
      <h2>Manage Users</h2>
      <p align="right">
        <a href="registration"><button class="primary">Add new Users</button></a>
      </p>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Image</th>
              <th scope="col">Name</th>
              <th scope="col">Gender</th>
              <th scope="col">Country</th>
              <th scope="col">Language</th>
              <th scope="col">Email Id</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="users" items="${lstusers}">
              <tr>
                <td>&nbsp;</td>
                <td><img src="image/${users.id}" width="50px" height="50px"/></td>
                <td>${users.firstName} ${users.lastName}</td>
                <td>${users.gender }</td>
                <td>${users.country }</td>
                <td><c:forEach var="lang" items="${users.language }">${lang}&nbsp;</c:forEach></td>
                <td>${users.emailId }</td>
                <td><a href="edit/${users.id }">Edit</a> | <a href="delete/${users.id }" 
                       onclick='return confirm("Are you sure you want to delete this Record???")'>Delete</a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
<!-- End of dashboard -->    

<!-- footer -->
    </main>
  </div>
</div>
<script src="${contextPath }/resources/admincss/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<!-- End of footer -->


















