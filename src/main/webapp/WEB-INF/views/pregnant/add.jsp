<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Woman</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styleaddedit.css"/>
	
  
</head>
<body>


<div class="header">
    <a href="/teacher/pregnant">Back</a>
    Add Pregnant Woman
</div>

<div class="content">
    <h2>Add woman</h2>

    <div class="form-container">
        <form action="<c:url value='/teacher/pregnant/save' />" method="post">
        	
            <input type="hidden" name="id" value="${woman.id}" />

            <label for="name">Name</label>
            <input type="text" name="name" id="name" value="${woman.name}" required />

            <label for="age">Age</label>
            <input type="number" name="age" id="age" value="${woman.age}" required />

            <label for="address">Address</label>
            <textarea name="address" id="address" rows="3" required>${woman.address}</textarea>

            <label for="dueDate">Due Date</label>
            <input type="date" name="dueDate" id="dueDate" value="${woman.dueDate}" required />

            <label for="phoneNumber">Phone Number</label>
            <input type="text" name="phoneNumber" id="phoneNumber" value="${woman.phoneNumber}" required />

            <input type="submit" value="Save" />
        </form>
    </div>
</div>

   <jsp:include page="/WEB-INF/views/footer.jsp" />
   
</body>
</html>
