<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Add Item</title>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/css/styleaddedit.css" />

</head>
<body>

	<div class="header">
		<a href="/teacher/items">Back</a>
		Add Item
	</div>

	<div class="content">
		<h2>Add Item</h2>

		<div class="form-container">
			<form action="<c:url value='/teacher/items/save' />" method="post">
				<input type="hidden" name="id" value="${item.id}" /> 
				<label for="itemName">Item Name</label> 
				<input type="text" id="itemName" name="itemName" value="${item.itemName}" required /> 
				<label for="quantity">Quantity</label> 
				<input type="number" id="quantity" name="quantity" value="${item.quantity}" required /> 
				
				<input type="submit" value="Save" />
			</form>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />

</body>
</html>
