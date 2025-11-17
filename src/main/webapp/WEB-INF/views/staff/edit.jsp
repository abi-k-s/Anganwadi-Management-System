<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Staff Member</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/stylestaffaddedit.css" />

</head>
<body>


	<div class="header">
		<a href="/teacher/staff">Back</a> Edit Staff Member
	</div>
	<div class="content">

		<h2>Edit Staff Member</h2>

		<div class="form-container">
			<form action="<c:url value='/teacher/staff/save' />" method="post">
				<input type="hidden" name="id" value="${staff.id}" /> <input
					type="hidden" name="user.id" value="${staff.user.id}" />

				<div class="form-group">
					<label>Name:</label> <input type="text" name="name"
						value="${staff.name}" required />
				</div>

				<div class="form-group">
					<label>Phone:</label> <input type="text" name="phoneNumber"
						value="${staff.phoneNumber}" required />
				</div>

				<div class="form-group">
					<label>Address:</label> <input type="text" name="address"
						value="${staff.address}" required />
				</div>

				<div class="form-group">
					<label>Role:</label> <select name="role">
						<option value="TEACHER"
							<c:if test="${staff.role.name() == 'TEACHER'}">selected</c:if>>TEACHER</option>
						<option value="ASSISTANT"
							<c:if test="${staff.role.name() == 'ASSISTANT'}">selected</c:if>>ASSISTANT</option>
					</select>
				</div>

				<div class="form-group">
					<label>Username:</label> <input type="text" name="user.username" value="${staff.user.username}" readonly />
				</div>

				<div class="form-group">
					<label>Password:</label> <input type="password" name="user.password" value="" placeholder="Leave blank to keep old" />
				</div>

				<input type="submit" value="Update" />
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />

</html>
