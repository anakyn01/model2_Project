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
<h1 class="my-5">view</h1>
<form role="form" method="post" autocomplete="off">
<input type="hidden" name="n" value="${goods.gdsNum}"/>

<div class="input-group">
<label class="form-label fw-bold">1차 분류</label>
<span class="ml-2"></span>
<label class="form-label fw-bold ml-2">2차 분류</label>
<span class="ml-2">${goods.cateCode}</span>
</div>

<div class="input-group mt-3">
<label class="form-label w-25 fw-bold">상품명</label>
<span class="w-75">${goods.gdsName}</span>
</div>

<div class="input-group mt-3">
<label class="form-label w-25 fw-bold">상품가격</label>
<span class="w-75"><fmt:formatNumber value="${goods.gdsPrice}" pattern="###,###,###"/></span>
</div>

<div class="input-group mt-3">
<label class="form-label w-25 fw-bold">상품수량</label>
<span class="w-75">${goods.gdsStock}</span>
</div>

<div class="input-group mt-3">
<label class="form-label w-25 fw-bold">상품소개</label>
<span class="w-75">${goods.gdsDes}</span>
</div>

<div class="d-flex justify-content-end my-5">
	<div class="btn-group">
		<button id="modify_Btn" class="btn btn-warning">수정</button>
		<button id="delete_Btn" class="btn btn-danger">삭제</button>
	</div>
</div>

<script>
var formObj = $("form[role='form']");

$("#modify_Btn").click(function(){
	formObj.attr("action","/admin/goods/modify");
	formObj.attr("method","get")
	formObj.submit();
});
$("#delete_Btn").click(function(){
	
	var con = confirm("정말로 삭제 하시겠습니까?")
	
	if(con){
		formObj.attr("action","/admin/goods/delete");
		formObj.submit();
	}

});
</script>

</form>
</main>
</div>
</div>
</div>
</div>


<jsp:include page="../../include/footer.jsp" flush="false"/>