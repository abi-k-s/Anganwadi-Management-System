<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Attendance Records</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylelist.css"/>
    <script>
			function confirmDelete(childName) {
				return confirm("Are you sure you want to delete " + childName + "?");
			}
		</script>
</head>
<body>

<!-- Header with Home link as per Role -->
<div class="header">
    <sec:authorize access="hasRole('TEACHER')">
        <a href="/teacher/dashboard">Home</a>
    </sec:authorize>
    <sec:authorize access="hasRole('ASSISTANT')">
        <a href="/assistant/dashboard">Home</a>
    </sec:authorize>
    <div>Attendance Management</div>
</div>

    <div class="content">

<h2>Attendance Records</h2>


<a href="/attendance/add" class="add-btn"><img src="${pageContext.request.contextPath}/images/add.png"  
			alt="Tick Image" />Mark Attendance</a>


<table>
    <thead>
        <tr>
            <th>Child</th>
            <th>Date</th>
            <th>Present</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="a" items="${attendances}">
        <tr>
            <td>${a.child.name}</td>
            <td>${a.date}</td>
            <td>
                <c:choose>
                    <c:when test="${a.present}"> <img src="${pageContext.request.contextPath}/images/check.png"  
			alt="Tick Image" />Yes</c:when>
                    <c:otherwise><img src="${pageContext.request.contextPath}/images/cross.png"  
			alt="Welcome Image" /> No</c:otherwise>
                </c:choose>
            </td>
            <td class="action-links">
                <a href="/attendance/edit/${a.id}">Edit</a> |
                <a href="/attendance/delete/${a.id}"onclick="return confirmDelete('${a.child.name}')">Delete</a></td>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

  <jsp:include page="/WEB-INF/views/footer.jsp" />


<!--  Alert for Duplicate -->
<c:if test="${param.duplicate eq 'true'}">
    <script>
        alert('Attendance already marked for this child!');
    </script>
</c:if>

</body>
</html>
