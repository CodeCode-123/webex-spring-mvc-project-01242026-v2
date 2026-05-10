<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Home Header -->
<%@ include file="homeheader.jsp"%>
<!-- End of Home Header -->

<!-- Home -->
<div class="container-fluid top-header" style="background-color: #b80818">
  <div class="banner-section">
    <div class="row">
      <div class="col-lg-1 col-12"></div>
      <div class="col-lg-5 col-md-7 col-12">
        <div class="banner-detail">
          <h5>Best Choice</h5>
          <h1>ITALIAN PIZZA</h1>
          <div class="col-md-12">
            <button class="btn button-1">Order Now</button>
            <button class="btn button-2">Full Menu</button>
          </div>
        </div>
      </div>
      <div class="col-lg-6 col-md-5 col-12">
        <div class="banner-img"><img src="resources/images/banner.png"/></div>
      </div>
    </div>
  </div>
</div>
<!-- ADV Section -->
<div class="container-fluid main-section">
  <div class="container">
    <div class="row">
      <c:forEach var="category" items="${categories }">
        <div class="col-lg-4 col-md-6">
          <div class="top-banner">
            <div class="row">
              <div class="col-md-7">
                <h2>SAVE 30%</h2>
                <h3>${category.categoryName }</h3>
                <p>${category.categoryDesc }</p>
              </div>
              <div class="col-md-5">
                <div><img src="resources/images/banner-1.png"/></div>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</div>
<div class="container-fluid main-section">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="heading-section">
          <h3>Our Top Sell</h3>
          <h2>Checkout Our Top Sell Items</h2>
          <div class="heading-borders"><span class="selected"></span></div>
        </div>
      </div>
    </div>
    <div class="row">
		<c:forEach var="item" items="${items }">
		<div class="col-lg-3 col-md-6">
		  <div class="famous-product">
		    <h2>${item.category.categoryName }</h2>
		    <h3>${item.itemName }</h3>
		    <img src="image/${item.itemId }"/>
		    <div class="price">
		      <h4>$ ${item.itemPrice }</h4>
		      <p>&nbsp;</p>
		      <span>
		      <a href="item/cart/${item.itemId }">
		        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="#b80818" class="bi bi-plus-circle" viewBox="0 0 16 16">
		          <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
		          <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
		        </svg>      
		      </a>
		      </span>
		    </div>
		  </div>
		</div>
		</c:forEach>
    </div>
  </div>
</div>
<!-- End of Home -->

<!-- Home Footer -->
<%@ include file="homefooter.jsp"%>
<!-- End of Home Footer -->