<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Assistant Dashboard</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styledashboard.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />


	<div class="nav-links">

		<a href="<c:url value='/attendance' />">Mark/View Attendance</a>

	</div>

	<div class="welcome-msg">Welcome,
		${pageContext.request.userPrincipal.name}!</div>
	<div class="dashboard-image">
		<img src="${pageContext.request.contextPath}/images/image.png"
			alt="Welcome Image" />
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>