<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Children List</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/stylelist.css" />

<script>
	function confirmDelete(childName) {
		return confirm("Are you sure you want to delete " + childName + "?");
	}
</script>
</head>
<body>


	<div class="header">
		<a href="/teacher/dashboard"><img
			src="${pageContext.request.contextPath}/images/home.png"
			alt="Home Image" />Home</a> <span>Children Management</span>
	</div>

	<div class="content">
		<h2>Children List</h2>


		<a href="/teacher/children/add" class="add-btn">+ Add New</a>


		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>DOB</th>
					<th>Height (cm)</th>
					<th>Weight (kg)</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${children}" var="c">
					<tr>
						<td title="${c.name}">${c.name}</td>
						<td>${c.age}</td>
						<td>${c.dob}</td>
						<td>${c.height}</td>
						<td>${c.weight}</td>
						<td title="${c.address}">${c.address}</td>
						<td>${c.phoneNumber}</td>
						<td class="action-links"><a
							href="/teacher/children/edit/${c.id}">Edit</a> | <a
							href="/teacher/children/delete/${c.id}"
							onclick="return confirmDelete('${c.name}')">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<jsp:include page="/WEB-INF/views/footer.jsp" />

</body>
</html>
