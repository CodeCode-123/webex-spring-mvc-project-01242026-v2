<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Adminheader -->
<%@ include file="adminheader.jsp" %>
<!-- End of Adminheader -->

<!-- Add Product -->
    <h2>Product</h2>
    <!-- modelAttribute set to be item -->
    <f:form action="save" method="POST" modelAttribute="item" enctype="multipart/form-data">
      <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Select Category</label>
        <f:select path="category.categoryId" class="form-control">
          <option value="-1">Select Category</option>
          <!-- categories are retrieved from the database -->
          <c:forEach var="category" items="${categories }">
            <!-- compare the ids of item.category and the categories in the options, if they are the same, display the categoryName -->
            <option value="${category.categoryId }" ${item.category.categoryId == category.categoryId ? 'selected' : '' }>${category.categoryName }</option>
          </c:forEach>
        </f:select>     
      </div>
      <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Item Name</label>
        <f:input path="itemName" class="form-control" />     
      </div>
      <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Item Price</label>
        <f:input path="itemPrice" class="form-control" /> 
      </div>
      <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Upload Image</label>
        <input type="file" name="photo" class="form-control" />
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </f:form>
<!-- End of Add Product -->

<!-- Footer -->
<%@ include file="footer.jsp" %>
<!-- End of Footer -->