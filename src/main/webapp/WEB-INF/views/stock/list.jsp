<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Item Stock</title>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylelist.css"/>
	    <script>
        function confirmDelete(itemName) {
            return confirm("Are you sure you want to delete " + itemName + "?");
        }
    </script>
</head>
<body>

<div class="header">
    <a href="/teacher/dashboard"> Home</a>
    <a href="<c:url value='/teacher/distribution' />">Item Distribution</a>
    <span>Item Stock Management</span>
</div>
<div class="content">
<h2>Item List</h2>


<a href="/teacher/items/add" class="add-btn"><img src="${pageContext.request.contextPath}/images/add.png"  
			alt="Tick Image" />Add Item</a>


<table>
    <thead>
        <tr>
            <th>Item Name</th>
            <th>Quantity(Kg/L)</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="i" items="${items}">
            <tr>
                <td>${i.itemName}</td>
                <td>${i.quantity}</td>
                <td class="action-links">
                    <a href="/teacher/items/edit/${i.id}">Edit</a> |
                    <a href="/teacher/items/delete/${i.id}" onclick="return confirmDelete('${i.itemName}')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>

   <jsp:include page="/WEB-INF/views/footer.jsp" />
   
</body>
</html>
