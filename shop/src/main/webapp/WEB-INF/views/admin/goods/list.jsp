<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../../include/header.jsp" flush="false"/>
<div class="container-fluid">
<div class="row">
<div class="col-md-12">
<div class="d-flex">
<aside class="w-25">
<jsp:include page="../include/lnb.jsp" flush="false"/>
</aside>
<main class="w-75 p-5">
<h1>list</h1>
<table class="table">
<colgroup>
<col style="width:10%"/>
<col style="width:50%"/>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:10%"/>
<col style="width:10%"/>
</colgroup>
<thead>
<tr>
<th>번호</th><th>이름</th><th>카테고리</th><th>가격</th><th>수량</th><th>등록날짜</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="list">
<tr>
<td>${list.gdsNum}</td>
<td>
<a href="/admin/goods/view?n=${list.gdsNum}">
${list.gdsName}
</a>
</td>
<td>${list.cateCode}</td>
<td>
<fmt:formatNumber value="${list.gdsPrice}" pattern="###,###,###"/>
</td>
<td>${list.gdsStock}</td>
<td>
<fmt:formatDate value="${list.gdsDate}" pattern="yyyy-MM-dd"/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</main>
</div>
</div>
</div>
</div>


<jsp:include page="../../include/footer.jsp" flush="false"/>