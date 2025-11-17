<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Anganwadi Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylelogin.css" />
</head>
<body>

    
    <div class="header">
        Welcome to Karamuck Anganwadi Portal
        <div class="quote">To see the world through a child's eyes</div>
    </div>

    <div class="login-container">
       <!--  <img src="https://cdn-icons-png.flaticon.com/512/3075/3075858.png" alt="Children Icon" class="child-icon" /> -->
        <h2>Staff Login</h2>

        <form method="post" action="/login">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required />
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required />
            </div>

            <div class="form-group">
                <button type="submit">Login</button>
            </div>
        </form>

        
        <c:if test="${param.error == 'true'}">
            <script>
                alert("Invalid username or password.");
            </script>
        </c:if>
    </div>

    
    <jsp:include page="/WEB-INF/views/footer.jsp" />

</body>
</html>
