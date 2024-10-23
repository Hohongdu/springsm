<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-10">

    <h2>Cust Search Page</h2>
    <form action="/item/findimpl" method="get">
        <div class="form-group">
            <div class="row">
                <div class="col-sm-2">
                    <h5>Search</h5>
                </div>
                <div class="col-sm-3">
                    <select class="form-control" name="keyword">
                        <option value="id"
                                <c:if test="${search.keyword == 'id'}"> selected </c:if>
                        >ID</option>
                        <option value="name"
                                <c:if test="${search.keyword == 'name'}"> selected </c:if>
                        >NAME</option>
                    </select>
                </div>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="search"
                    <c:if test="${search.search != null}"> value="${search.search}" </c:if>
                    >
                </div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </div>
    </form>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>RegDate</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${cpage.getList()}">
            <tr>
                <td><a href="/item/detail?id=${c.id}">${c.id}</a></td>
                <td>${c.name}</td>
                <td>${c.price}</td>
                <td>${c.regdate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${cpage.getSize() != null}">
        <jsp:include page="../searchnav.jsp"/>
    </c:if>
</div>