<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<jsp:include page="../include/header.jsp" flush="false"/>
<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">목록</h1>
<table class="table">
<colgroup>
<col style="width:5%"/>
<col style="width:60%"/>
<col style="width:20%"/>
<col style="width:10%"/>
<col style="width:5%"/>
</colgroup>
<thead>
<tr>
<th class="text-center">번호</th><th class="text-center">제목</th><th class="text-center">작성일</th><th class="text-center">작성자</th><th class="text-center">조회수</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="list">
 <tr>
  <td class="text-center">${list.bno}</td>
  <td>
  <a href="/board/view?bno=${list.bno}"> ${list.title}</a>  
  </td>
  <td class="text-center">${list.regDate}</td>
  <td class="text-center">${list.writer}</td>
  <td class="text-center">${list.viewCnt}</td>
 </tr>
</c:forEach>
</tbody>
</table>
<form>
<div class="d-flex justify-content-center my-5">
<div class="input-group w-50">
	<select name="searchType" class="form-select">
		<option value="title" <c:if test="${page.searchType eq 'title'}">selected</c:if>>
		제목</option>
		<option value="content" <c:if test="${page.searchType eq 'content'}">selected</c:if>>
		내용</option>
		<option value="title_content"<c:if test="${page.searchType eq 'title_content'}">selected</c:if>>
		제목+내용</option>
		<option value="writer"<c:if test="${page.searchType eq 'writer'}">selected</c:if>>
		작성자</option>
	</select>
	<input type="text" name="keyword" class="form-control" value="${page.keyword}"/>
	<input type="submit" class="btn btn-outline-success" id="searchBtn" value="검색"/>
  </div>
</div>
</form>

<div class="d-flex justify-content-center my-5">
<ul class="pagination">
<c:if test="${page.prev}">
  <li class="page-item"><a href="/board/listPageSearch?num=${page.startPageNum -1}${page.searchTypeKeyword}" class="page-link">[이전]</a></li>
</c:if>
<c:forEach begin='${page.startPageNum}' end="${page.endPageNum}" var="num">
	<c:if test="${select != num }">
		<li class="page-item"><a href="/board/listPageSearch?num=${num}${page.searchTypeKeyword}" class="page-link">${num}</a></li>
	</c:if>
	<c:if test="${select == num }">
	<li class="page-item"><a href="/board/listPageSearch?num=${num}${page.searchTypeKeyword}" class="page-link"><b class="fw-bold">${num}</b></a></li>
	</c:if>
</c:forEach>
<c:if test="${page.next}">
<li class="page-item"><a href="/board/listPageSearch?num=${page.endPageNum + 1 }${page.searchTypeKeyword}" class="page-link">[다음]</a></li>
</c:if>
	<%-- <c:forEach begin='1' end="${pageNum}" var="num">
	<span>
	<a href="/board/listPage?num=${num}">${num}</a>
	</span>
	</c:forEach>--%>
</ul>
</div>
<div class="d-flex justify-content-end my-5">
<a href="/board/write" class="btn btn-outline-primary">Write</a>
</div>
</div>
</div>
</div>
<jsp:include page="../include/footer.jsp" flush="false"/>