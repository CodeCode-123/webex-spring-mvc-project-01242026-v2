<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Adminheader -->
<%@ include file="adminheader.jsp" %>
<!-- End of Adminheader -->

<!-- Add Category -->
<h2>Category</h2>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<f:form action="${contextPath }/admin/category/editcategory" method="POST" modelAttribute="category">
  <p><f:hidden path="categoryId"/></p>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Category Name</label>
    <f:input path="categoryName" class="form-control"/>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Category Description</label>
    <f:input path="categoryDesc" class="form-control"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</f:form>
<!-- End of Add Category -->

<!-- Footer -->
<%@ include file="footer.jsp" %>
<!-- End of Footer -->