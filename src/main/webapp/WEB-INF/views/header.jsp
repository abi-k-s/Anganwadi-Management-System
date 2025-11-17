<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head> 
 <!-- Header -->
    <div class="navbar">
        <div class="nav-left">Anganwadi Dashboard</div>
        <div class="nav-right">
            <form action="<c:url value='/logout' />" method="post">
            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><!-- should be added if csrf token is not disabled -->
                <input type="submit" value="Logout" />
            </form>
        </div>
    </div>

</body>
</html>    