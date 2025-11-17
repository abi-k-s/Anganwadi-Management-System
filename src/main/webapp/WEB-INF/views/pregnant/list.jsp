<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Pregnant Women List</title>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/stylelist.css" />
		<script>
			function confirmDelete(name) {
				return confirm("Are you sure you want to delete " + name + "?");
			}
		</script>
</head>
<body>

	
	<div class="header">
		<a href="/teacher/dashboard"> Home</a> <span>Pregnant Women
			Management</span>
	</div>

	<h2>Pregnant Women</h2>

	
	<a href="/teacher/pregnant/add" class="add-btn">+Add New</a>


	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>Due Date</th>
				<th>Phone</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="w" items="${woman}">
				<tr>
					<td>${w.name}</td>
					<td>${w.age}</td>
					<td>${w.address}</td>
					<td>${w.dueDate}</td>
					<td>${w.phoneNumber}</td>
					<td class="action-links"><a
						href="/teacher/pregnant/edit/${w.id}">Edit</a> | <a
						href="/teacher/pregnant/delete/${w.id}"
						onclick="return confirmDelete('${w.name}')">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<jsp:include page="/WEB-INF/views/footer.jsp" />
	
</body>
</html>
