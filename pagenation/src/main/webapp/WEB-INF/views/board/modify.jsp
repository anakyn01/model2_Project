<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<jsp:include page="../include/header.jsp" flush="false"/>
<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">게시물 수정</h1>
<form method="post">
<div class="input-group my-3">
	<label class="form-label">
	제목
	</label>
	<input type="text" name="title" class="form-control" value="${view.title}"/>
</div>
<div class="input-group mb-3">
	<label class="form-label">
	작성자
	</label>
	<input type="text" name="writer" class="form-control" value="${view.writer}"/>
</div>
<div class="input-group mb-3">
	<label class="form-label">
	내용
	</label>
	<textarea name="content" class="form-control">${view.content}</textarea>
</div>
<div class="d-flex justify-content-end my-5">
<button type="submit" class="btn btn-outline-primary">전송</button>
</div>
</form>
</div>
</div>
</div>
<jsp:include page="../include/footer.jsp" flush="false"/>