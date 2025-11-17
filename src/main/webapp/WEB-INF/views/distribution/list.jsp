<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Distribution List</title>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylelist.css"/>
	 <script>
        function confirmDelete(name) {
            return confirm("Are you sure you want to delete " + name + "?");
        }
    </script>
</head>
<body>

<div class="header">
    <a href="/teacher/dashboard">Home</a>
    <span>Item Distribution List</span>
</div>
<div class="content">
<h2>Distribution Records</h2>


<a href="/teacher/distribution/add" class="add-btn"><img src="${pageContext.request.contextPath}/images/add.png"  
			alt="Tick Image" />Add Distribution</a>


<table>
    <thead>
        <tr>
            <th>Woman</th>
            <th>Item</th>
            <th>Qty</th>
            <th>Month</th>
            <th>Year</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="d" items="${distributions}">
            <tr>
                <td>${d.woman.name}</td>
                <td>${d.item.itemName}</td>
                <td>${d.quantity}</td>
                <td>${d.month}</td>
                <td>${d.year}</td>
                <td class="action-links">
                    <a href="/teacher/distribution/edit/${d.id}">Edit</a> |
                    <a href="/teacher/distribution/delete/${d.id}" onclick="return confirmDelete('${d.woman.name}')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>

   <jsp:include page="/WEB-INF/views/footer.jsp" />

<c:if test="${param.duplicate eq 'true'}">
    <script>
        alert('Item already Distributed for the Month!');
    </script>
</c:if>

</body>
</html>
