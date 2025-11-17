<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Staff List</title>
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylelist.css"/>
   
</head>
<body>

<div class="header">
    <a href="/teacher/dashboard">Home</a>
    Staff Management
</div>
    <div class="content">

<h2>Staff Members</h2>

<a href="/teacher/staff/add" class="add-btn">Add Staff Member</a>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="s" items="${staff}">
            <tr>
                <td>${s.name}</td>
                <td>${s.phoneNumber}</td>
                <td>${s.address}</td>
                <td>${s.role}</td>
                <td class="action-links">
                    <a href="${pageContext.request.contextPath}/teacher/staff/edit/${s.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/teacher/staff/delete/${s.id}"
                       onclick="return confirm('Are you sure you want to delete ${s.name}?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>


 
   <jsp:include page="/WEB-INF/views/footer.jsp" />

</body>
</html>
