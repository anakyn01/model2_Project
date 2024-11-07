<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<jsp:include page="../include/header.jsp" flush="false"/>
<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">게시물 보기</h1>

<div class="input-group my-3">
	<label class="form-label w-25">
	제목
	</label>
	<label class="form-label w-75">${view.title}</label>
</div>
<hr/>
<div class="input-group mb-3">
	<label class="form-label w-25">
	작성자
	</label>
	<label class="form-label w-75">${view.writer}</label>
</div>
<hr/>
<div class="input-group mb-3">
	<label class="form-label w-25">
	내용
	</label>
	<label class="form-label w-75">${view.content}</label>
</div>
<hr/>
<div class="d-flex justify-content-end my-5">
	<div class="btn-group">
		<a class="btn btn-outline-primary" href="/board/listPage?num=1">목록</a>
		<a class="btn btn-outline-success" href="/board/modify?bno=${view.bno}">수정</a>
		<a class="btn btn-outline-danger" href="/board/delete?bno=${view.bno}">삭제</a>
	</div>
</div>
<!-- 댓글 시작 -->
<hr/>
<ul class="list-group">
<c:forEach items="${reply}" var="reply">
	<li class="list-group-item">
		<div>
			<p class="text-secondary">${reply.writer}/ <fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd"/></p>
			<p class="text-secondary">${reply.content}</p>			
		</div>
		<div class="d-flex justify-content-end my-5">
			<div class="btn-group">
				<a href="/reply/modify?bno=${view.bno}&rno=${reply.rno}" class="btn btn-outline-success">수정</a>
				<a href="" class="btn btn-outline-danger">삭제</a>
			</div>
		</div>
	</li>
</c:forEach>
</ul>

<form method="post" action="/reply/write">
<div class="input-group my-5">
	<label class="form-label">
	댓글 작성자
	</label>
	<input type="text" class="form-control" name="writer">
</div>
<textarea class="form-control" name="content"></textarea>
<input type="hidden" name="bno" value="${view.bno}">
<div class="my-3 d-flex justify-content-end">
<input type="submit" value="댓글작성" class="btn btn-light"/>
</div>
</form>











</div>
</div>
</div>
<jsp:include page="../include/footer.jsp" flush="false"/>