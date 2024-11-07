<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-3">생성하기</h1>
<form method="POST">
<div class="form-group my-3"><label class="form-label">제목 : </label><input type="text" name="title" class="form-control"/></div>
<div class="form-group my-3"><label class="form-label">카테고리 : </label><input type="text" name="category" class="form-control"/></div>
<div class="form-group my-3"><label class="form-label">가격 : </label><input type="text" name="price" class="form-control"/></div>

<div class="d-flex justify-content-end">
<p class="my-3">
<input type="submit" value="저장" class="btn btn-outline-success btn-lg"/>
</p>
</div>
</form>

</div>
</div>
</div>
<%@ include file="../include/footer.jsp" %>