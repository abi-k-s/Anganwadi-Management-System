<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Teacher Dashboard</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styledashboard.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<!-- Navigation Links -->
	<div class="nav-links">
		<a href="<c:url value='/teacher/children' />">Manage Children</a> <a
			href="<c:url value='/attendance' />">Mark/View Attendance</a> <a
			href="<c:url value='/teacher/pregnant' />">Pregnant Women Info</a> <a
			href="<c:url value='/teacher/items' />">Manage Item Stock</a> <a
			href="<c:url value='/teacher/distribution' />">Item Distribution</a>
		<a href="<c:url value='/teacher/staff' />">Staff Management</a>
	</div>

	<!-- Welcome Message -->
	<div class="welcome-msg">Welcome,${pageContext.request.userPrincipal.name}!</div>
	<div class="dashboard-image">
		<img src="${pageContext.request.contextPath}/images/image.png" alt="Welcome Image" />
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
