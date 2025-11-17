<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!-- to persist data -->

<!DOCTYPE html>
<html>
<head>
<title>Add Staff Member</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/stylestaffaddedit.css" />


</head>
<body>

	<div class="header">
		<a href="/teacher/staff">Back</a> Add Staff Member
	</div>
	<div class="content">

		<h2>Add Staff Member</h2>

		<div class="form-container">
			<form:form modelAttribute="staff"
				action="${pageContext.request.contextPath}/teacher/staff/save"
				method="post">
				<c:if test="${duplicate == true}">
					<script>
						alert('Username already exists..Please provide another Username');
					</script>
				</c:if>

				<div class="form-group">
					<label>Name:</label>
					<form:input path="name" required="required" />
				</div>

				<div class="form-group">
					<label>Phone:</label>
					<form:input path="phoneNumber" required="required" />
				</div>

				<div class="form-group">
					<label>Address:</label>
					<form:input path="address" required="required" />
				</div>

				<div class="form-group">
					<label>Role:</label>
					<form:select path="role">
						<form:option value="TEACHER">TEACHER</form:option>
						<form:option value="ASSISTANT">ASSISTANT</form:option>
					</form:select>
				</div>

				<div class="form-group">
					<label>Username:</label>
					<form:input path="user.username" required="required" />
				</div>

				<div class="form-group">
					<label>Password:</label>
					<form:password path="user.password" required="required" />
				</div>

				<input type="submit" value="Save" />
			</form:form>
		</div>
	</div>


	<jsp:include page="/WEB-INF/views/footer.jsp" />

</body>
</html>
