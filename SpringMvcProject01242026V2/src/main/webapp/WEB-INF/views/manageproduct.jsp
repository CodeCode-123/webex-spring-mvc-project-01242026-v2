<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!-- Adminheader -->
<%@ include file="adminheader.jsp" %>
<!-- End of Adminheader -->

<!-- Manage Product -->
    <h2>Manage Product</h2>
    <p align="right"><a href="add"><button class="btn btn-primary">Add New Product</button></a></p>
    <div>
      <table>
        <thead>
          <tr>
            <th>Item Id</th>
            <th>Item Name</th>
            <th>Category Name</th>
            <th>Item Price</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="item" items="${items }">
            <tr>
              <td><img src="image/${item.itemId }" class="img-round" height="50px" width="50px"/></td>
              <td>${item.itemName }</td>
              <td>${item.category.categoryName }</td>
              <td>${item.itemPrice }</td>
              <td>
                <a href="edit/${item.itemId }">
                  <img src="../../resources/svg/pencil-fill.svg" alt="edit"/>
                </a>&nbsp; | &nbsp;
                <a href="delete/${item.itemId }" onclick="return confirm('Are you sure you want to delete this record?')">
                  <img src="../../resources/svg/trash-fill.svg" alt="delete" />
                </a>
              </td>
            </tr>          
          </c:forEach>
        </tbody>
      </table>    
    </div>
<!-- End of Manage Product -->

<!-- Footer -->
<%@ include file="footer.jsp" %>
<!-- End of Footer -->