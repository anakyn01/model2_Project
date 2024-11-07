<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
<h1 class="mt-3 mb-2">목록</h1>
<form>
<div class="input-group">
	<input type="text" placeholder="검색" name="keyword" value="${keyword}" class="form-control"/>
	<input type="submit" value="검색" class="btn btn-outline-success"/>
</div>
</form>
<table class="table table-hover">
    <thead>
        <tr>
            <th>제목</th><th>카테고리</th><th>가격</th><th>작성일</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="row" items="${data}">
<tr>
    <td>
        <a href="/detail?bookId=${row.book_id}">${row.title}</a><!--표현언어-->
    </td>
    <td>
        ${row.category}
    </td>
    <td>
        <fmt:formatNumber type="number" maxFractionDigits="3" value="${row.price}"/>
    </td>
    <td>
        <fmt:formatDate value="${row.insert_date}" pattern="yyyy.MM.dd HH:mm:ss"/>
    </td>
</tr>            
        </c:forEach>
    </tbody>
</table>  
<div class="d-flex justify-content-end my-3">
<a class="btn btn-outline-success" href="/create">
    글쓰기
</a>
</div>          
        </div>
    </div>
</div>
<%@ include file="../include/footer.jsp" %>
