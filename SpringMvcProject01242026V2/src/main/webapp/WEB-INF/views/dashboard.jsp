<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!-- Adminheader -->
<%@ include file="adminheader.jsp" %>   
<!-- End of Adminheader -->
   
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
<!-- End of Dashboard --> 

<!-- Footer -->
<%@ include file="footer.jsp" %>   
<!-- End of Foot -->



















