<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Child</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styleaddedit.css" />

<script>
	function calculateAge() {
		const dobInput = document.getElementById("dob");
		const ageInput = document.getElementById("age");

		if (dobInput.value) {
			const dob = new Date(dobInput.value);
			const today = new Date();
			let age = today.getFullYear() - dob.getFullYear();
			const m = today.getMonth() - dob.getMonth();

			if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) {
				age--;
			}

			ageInput.value = age;
		} else {
			ageInput.value = "";
		}
	}
</script>
</head>
<body>

	
	<div class="header">
		<a href="/teacher/children"> Back</a> Edit Child Details
	</div>


	<div class="content">
		<h2>Edit Child</h2>

		<div class="form-container">
			<form action="<c:url value='/teacher/children/save' />" method="post">
				<input type="hidden" name="id" value="${child.id}" /> <label
					for="name">Name</label> <input type="text" id="name" name="name"
					value="${child.name}" required /> <label for="dob">Date of
					Birth</label> <input type="date" id="dob" name="dob" value="${child.dob}"
					onchange="calculateAge()" required /> <label for="age">Age</label>
				<input type="number" id="age" name="age" value="${child.age}"
					readonly /> <label for="height">Height (cm)</label> <input
					type="text" id="height" name="height" value="${child.height}"
					required /> <label for="weight">Weight (kg)</label> <input
					type="text" id="weight" name="weight" value="${child.weight}"
					required /> <label for="address">Address</label>
				<textarea id="address" name="address" rows="3" required>${child.address}</textarea>

				<label for="phoneNumber">Phone Number</label> <input type="text"
					id="phoneNumber" name="phoneNumber" value="${child.phoneNumber}"
					required /> <input type="submit" value="Save" />
			</form>
		</div>
	</div>



	<jsp:include page="/WEB-INF/views/footer.jsp" />

</body>
</html>
