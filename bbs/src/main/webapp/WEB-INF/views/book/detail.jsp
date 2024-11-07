<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %> 
<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-3">상세페이지</h1>
<table class="table table-borderd">
<tr>
<th>제목</th><td>${data.title}</td>
</tr>
<tr>
<th>카테고리</th><td>${data.category}</td>
</tr>
<tr>
<th>가격</th>
<td>
<fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price}"/>
</td>
</tr>
<tr>
<th>입력일</th>
<td>
<fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH:mm:ss"/><!--  -->
</td>
</tr>

</table>

<div class="d-flex justify-content-end">
<form method="POST" action="/delete">
<div class="btn-group">
<a href="/update?bookId=${bookId}" class="btn btn-outline-success">수정</a>

 <input type="hidden" name="bookId" value="${bookId}"/>
 <input type="submit" value="삭제" class="btn btn-outline-danger"/>

<a href="/list" class="btn btn-outline-primary">목록으로</a>
</div>
</form>
</div>
</div>
</div>
</div>
<%@ include file="../include/footer.jsp" %>