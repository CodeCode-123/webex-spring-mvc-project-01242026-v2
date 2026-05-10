<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Home Header -->
<%@ include file="homeheader.jsp"%>
<!-- End of Home Header -->

<!-- Home -->
<div class="container-fluid top-header" style="background-color: #b80818">
  <div class="banner-section"></div>
</div>
<!-- ADV Section -->
<div class="container-fluid main-section">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="heading-section">
          <h3>Carts</h3>
          <h2>Items</h2>
          <div class="heading-borders"><span class="selected"></span></div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Item Name</th>
              <th scope="col">Price</th>
              <th scope="col">Qty</th>
              <th scope="col">Value</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <c:forEach var="item" items="${carts }">
            <form action="${contextPath }/item/cart/update" method="POST">
              <tr>
                <td><img src="${contextPath }/image/${item.itemId}" width="50px" height="50px"/></td>
                <td>${item.itemName }</td>
                <td>${item.itemPrice }</td>
                <td><input type="number" name="qty" id="qty" value="${item.qty }"/></td>
                <td>${item.amount }</td>
                <td>
                  <input type="hidden" value="${item.itemId }" name="itemId" id="itemId"/>
                  <button type="submit" class="primary">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                      <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z"/>
                    </svg>
                  </button>
                  &nbsp; <a href="${contextPath }/item/cart/delete/${item.itemId}" onclick="return confirm('Are you sure you want to delete this item??')">
                           <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                             <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"/>
                           </svg>
                  </a>
                </td>
              </tr>
            </form>   
          </c:forEach>
          <tr>
            <td colspan="4"><h3>Total Amount</h3></td>
            <td align="left"><h3>${totalAmount }</h3></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td colspan="6" align="right">
              <a href="${contextPath }/checkout">Checkout</a>
            </td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</div>
<!-- End of Home -->

<!-- Home Footer -->
<%@ include file="homefooter.jsp"%>
<!-- End of Home Footer -->