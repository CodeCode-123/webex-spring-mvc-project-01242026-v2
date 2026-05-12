<!-- Home Header -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<head>
<title>Project</title>
<meta charset="UTF-8">
<meta name="viewpoint" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${contextPath }/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath }/resources/css/owl.carousel.css">
<link rel="stylesheet" href="${contextPath }/resources/css/style.css">
<link rel="stylesheet" href="${contextPath}/resources/admincss/css/bootstrap.min.css"/>
</head>
<body>
<div class="container-fluid top-header">
  <nav class="navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-3 col-4">
          <a class="navbar-brand" href="#"><img src="${contextPath }/resources/images/logo.png" /></a>
        </div>
        <div class="col-lg-6 col-md-6 col-2">
          <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item"><a class="nav-link" aria-current="page" href="${contextPath }/">Home</a></li>
              <li class="nav-item"><a class="nav-link" href="#">Category</a></li>
              <li class="nav-item"><a class="nav-link" href="#">Menu List</a></li>
              <li class="nav-item"><a class="nav-link" href="#">Our Services</a></li>
              <li class="nav-item"><a class="nav-link" href="#">Testimonial</a></li>
              <li class="nav-item"><a class="nav-link" href="#">Contact Us</a></li>
            </ul>
          </div>
        </div>
        <div class="col-lg-3 col-md-3 col-6 social-media">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
          </button>
          <a href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
              <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
            </svg>
          </a>
          <a href="${contextPath }/item/cart/home">
            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-cart-plus-fill" viewBox="0 0 16 16">
              <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0m7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0M9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0" />
            </svg>
          </a>
        </div>
      </div>
    </div>
  </nav>
</div>
<!-- End of Home Header -->


