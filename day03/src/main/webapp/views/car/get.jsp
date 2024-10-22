<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>

<style>
    #car_img {
        width: 200px; /* 필요 시 추가 */
    }
</style>

<div class="col-sm-10">

    <h2>Car Get Page</h2>
    <br>
    <h5>차량 검색</h5>
    <form action="<c:url value='/car/search'/>" method="GET" class="mb-3">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="차량 이름 검색" name="carName">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="submit">검색</button>
            </div>
        </div>
    </form>

    <h5>차량 목록</h5>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Color</th>
            <th>Price</th>
            <th>Production Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${cars}">
            <tr>
                <td><a href="/car/detail?id=${c.carId}">${c.carName}</a></td>
                <td>${c.carColor}</td>
                <td>
                    <fmt:formatNumber type="number" pattern="###,###원" value="${c.carPrice}" />
                </td>
                <td>
                    <c:choose>
                        <c:when test="${not empty c.carDate}">
                            <fmt:formatDate value="${c.carDate}" pattern="yyyy년 MM월 dd일"/>
                        </c:when>
                        <c:otherwise>
                            날짜 없음
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
