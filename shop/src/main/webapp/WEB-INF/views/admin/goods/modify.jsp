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
<h1 class="my-5">Update</h1>
<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
<input type="hidden" name="gdsNum" value="${goods.gdsNum}"/>

<div class="input-group">
<label class="form-label fw-bold">1차 분류</label>
<select class="form-select category1">
<option value="">전체</option>
</select>
<label class="form-label fw-bold ml-2">2차 분류</label>
<select class="form-select category2" name="cateCode">
<option value="">전체</option>
</select>
</div>

<div class="input-group mt-3">
<label class="form-label w-25 fw-bold">상품명</label>
<input type="text" id="gdsName" name="gdsName" value="${goods.gdsName}" class="form-control"/>
</div>

<div class="input-group mt-3">
<label class="form-label w-25 fw-bold">상품가격</label>
<input type="text" id="gdsPrice" name="gdsPrice" value="${goods.gdsPrice}" class="form-control"/>
</div>

<div class="input-group mt-3">
<label class="form-label w-25 fw-bold">상품수량</label>
<input type="text" id="gdsStock" name="gdsStock" value="${goods.gdsStock}" class="form-control"/>
</div>

<div class="input-group mt-3">
<label class="form-label w-25 fw-bold">상품소개</label>
<textarea rows="" cols="" class="form-control" id="gdsDes" name="gdsDes">${goods.gdsDes}</textarea>
</div>

<!-- 이미지 추가 -->
<div class="input-group mt-3">
	<label class="form-label w-25 fw-bold" for="gdsImg">이미지</label>
		<input type="file" id="gdsImg" name="file" class="form-control"/>
		<div class="select_img">
		<img src="${goods.gdsImg}"/>
		<input type="hidden" name="gdsImg" value="${goods.gdsImg}"/>
		<input type="hidden" name="gdsThumbImg" value="${goods.gdsThumbImg}"/>
		</div>
</div>
<script>
$('#gdsImg').change(function(){//셀렉터[gdsImg]를 정하여 해당 셀렉터의 값이 변할경우 변화를 캐치하는 이벤트
	if(this.files && this.files[0]){
		var reader = new FileReader;
		reader.onload = function(data){
			$(".select_img img").attr("src",data.target.result).width(500);
		}
		reader.readAsDataURL(this.files[0])
	}
})
</script>

<div class="d-flex justify-content-end my-5">
	<div class="btn-group">
		<button type="submit" id="update_Btn" class="btn btn-primary">완료</button>
		<button type="submit" id="back_Btn" class="btn btn-warning">취소</button>
	</div>
</div>

<script>


$("#back_Btn").click(function(){
//location.href="/admin/goods/view?n" + ${goods.gdsNum};
history.back()
});

var select_cateCode = '${goods.cateCode}';
var select_cateCodeRef = '${goods.cateCodeRef}';
var select_cateName = '${goods.cateName}';

if(select_cateCodeRef != null && select_cateCodeRef != ''){
	$(".category1").val(select_cateCodeRef);
	$(".category2").val(select_cateCode);
	$(".category2").children().remove();
	$(".category2").append("<option value='" + select_cateCode + "'>" + select_cateName + "</option>");
}else{
	$(".category1").val(select_cateCode);
	//$(".category2").val(select_cateCode);
	$(".category2").append("<option value='" +select_cateCode + "' selected='selected'> 전체 "</option>");
}
</script>

</form>
</main>
</div>
</div>
</div>
</div>


<jsp:include page="../../include/footer.jsp" flush="false"/>