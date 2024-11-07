<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>  
<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-3">update</h1>
<form method="POST">
<table class="table table-borderd">
<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" value="${data.title}" class="form-control"/>
	</td>
</tr>
<tr>
<th>카테고리</th>
	<td>
		<input type="text" name="category" value="${data.category}" class="form-control"/>
	</td>
</tr>
<tr>
<th>가격</th>
<td>
<input type="text" name="price" value="${data.price}" class="form-control"/>
</td>
</tr>
</table>

<div class="d-flex justify-content-end">
	<div class="btn-group">
	 <input type="submit" value="update" class="btn btn-outline-success"/>
	 <a href="/list" class="btn btn-outline-primary">목록으로</a>
	</div>
</div>

</form>
</div>
</div>
</div>
<%@ include file="../include/footer.jsp" %>