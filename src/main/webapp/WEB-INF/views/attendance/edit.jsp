<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Attendance</title>
    	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styleattendanceaddedit.css"/>
 
</head>
<body>


<div class="header">
		<a href="/attendance">Back</a>
		Edit Attendance
</div>

<div class="content">
    <h2>Edit Attendance</h2>

    <div class="form-container">
        <form action="<c:url value='/attendance/save' />" method="post">
            <input type="hidden" name="id" value="${attendance.id}" />

            <label for="child">Child</label>
            <select name="child.id" id="child" required>
                <c:forEach var="c" items="${children}">
                    <option value="${c.id}" ${attendance.child.id == c.id ? 'selected' : ''}>${c.name}</option>
                </c:forEach>
            </select>

            <label for="date">Date</label>
            <input type="date" name="date" id="date" value="${attendance.date}" required />

            <div class="checkbox-wrapper">
                <input type="checkbox" name="present" id="present" class="custom-checkbox"
                       ${attendance.present ? 'checked' : ''} />
                <label for="present">Present</label>
            </div>

            <input type="submit" value="Save" />
        </form>
    </div>
</div>


 <jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
