<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Add Distribution</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styledistributionaddedit.css" />


</head>
<body>


	<div class="header">
		<a href="/teacher/distribution">Back</a> Add Distribution
	</div>

	<div class="content">
		<h2>Add Distribution</h2>

		<div class="form-container">
			<form action="<c:url value='/teacher/distribution/save' />"
				method="post">
				<c:if test="${not empty errorMessage}">
					<script type="text/javascript">
						alert("${errorMessage}");
					</script>
				</c:if>
				<input type="hidden" name="id" value="${distribution.id}" /> <label
					for="woman">Select Woman:</label> <select name="woman.id"
					id="woman" required>
					<c:forEach var="w" items="${women}">
						<option value="${w.id}"
							${distribution.woman.id == w.id ? 'selected' : ''}>${w.name}</option>
					</c:forEach>
				</select> <label for="item">Select Item:</label> <select name="item.id"
					id="item" required>
					<c:forEach var="i" items="${items}">
						<option value="${i.id}"
							${distribution.item.id == i.id ? 'selected' : ''}>${i.itemName}</option>
					</c:forEach>
				</select> <label for="quantity">Quantity:</label> <input type="number"
					name="quantity" id="quantity" value="${distribution.quantity}"
					required /> <label for="month">Month:</label> <select name="month"
					id="month" required>
					<c:forEach var="m" items="${months}">
						<option value="${m}" ${distribution.month == m ? 'selected' : ''}>${m}</option>
					</c:forEach>
				</select> <label for="year">Year:</label> <select name="year" id="year"
					required>
					<c:forEach var="y" items="${years}">
						<option value="${y}" ${distribution.year == y ? 'selected' : ''}>${y}</option>
					</c:forEach>
				</select> <input type="submit" value="Save" />
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />

</body>
</html>
