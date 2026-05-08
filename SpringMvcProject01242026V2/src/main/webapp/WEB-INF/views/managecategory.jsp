<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Adminheader -->
<%@ include file="adminheader.jsp" %>
<!-- End of Adminheader -->

<!-- Manage Category -->
    <h2>Manage Category</h2>
    <p align="right"><a href="add"><button class="btn btn-primary">Add New Category</button></a></p>
    <div class="table-responsive">
      <table class="table table-striped table-sm">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="category" items="${categories }">
            <tr>
              <td>${category.categoryId }</td>
              <td>${category.categoryName }</td>
              <td>${category.categoryDesc }</td>
              <td>
                <a href="edit/${category.categoryId }">
                  <img src="../../resources/svg/pencil-fill.svg" alt="edit"/>
                </a>&nbsp; | &nbsp;
                <a href="delete/${category.categoryId }" 
                   onclick="return confirm('Are you sure you want to delete this record?')">
                  <img src="../../resources/svg/trash-fill.svg" alt="delete" />                
                </a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
<!-- End of Manage Category -->

<!-- Footer -->
<%@ include file="footer.jsp" %>
<!-- End of Footer -->