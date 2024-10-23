<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-10">
    <h2>Error Page</h2>
    <p>${msg}</p>
    <c:if test="${not empty errorCode}">
        <p><strong>Error Code:</strong> ${errorCode}</p>
    </c:if>
    <c:if test="${not empty errorDetail}">
        <p><strong>Error Detail:</strong> ${errorDetail}</p>
    </c:if>
    <c:if test="${not empty stackTrace}">
        <h4>Stack Trace:</h4>
        <pre>${stackTrace}</pre>
    </c:if>
    <p><a href="<c:url value='/'/>">Go to Home</a></p>
</div>
