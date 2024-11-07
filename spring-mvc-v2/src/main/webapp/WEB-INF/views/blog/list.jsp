<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" flush="false"/>
<div class="container">
<div class="row">
<div class="col-md-12">

<form class="my-5">
	<div class="input-group">
		<input type="text" 
		class="form-control" 
		placeholder="Search" 
		name="search" 
		value="${blogListRequestVO.search}"
		/>
		<input 
		type="submit" 
		name="search_button" 
		value="검색"
		class="btn btn-outline-success"/>
	</div>
</form>

<c:if test="${not empty blogListResponseVOList}">
<table class="table table-hover">
<colgroup>
<col style="width:5%"/>
<col style="width:70%"/>
<col style="width:15%"/>
<col style="width:10%"/>
</colgroup>
	<thead>
		<tr>
			<th class="text-center">글번호</th>
			<th class="text-center">제목</th>
			<th class="text-center">입력일</th>
			<th class="text-center">수정</th>
		</tr>
	</thead>
<c:forEach var="blogListResponseVO" items="${blogListResponseVOList}">
	<tbody>
	<tr>
	<td>${blogListResponseVO.blgContSeq}</td>
	<td><a href="/read/${blogListResponseVO.blgContSeq}" class="a-link">${blogListResponseVO.title}</a></td>
	<td>${blogListResponseVO.insertDtFormat}</td>
	<td class="text-center">
	<a href="/edit/${blogListResponseVO.blgContSeq}" class="a-link">
	수정
	</a>
	</td>
	</tr>
	</tbody>
</c:forEach>
</table>
<div class="d-flex justify-content-end my-5">
	<div class="btn-group">
		<a href="/create" class="btn btn-outline-primary px-4">글쓰기</a>
	</div>
</div>
</c:if>
<c:if test="${empty blogListResponseVOList}">
<strong>검색 결과가 없습니다</strong>
</c:if>
</div>
</div>
</div>
<jsp:include page="../include/footer.jsp" flush="false"/>