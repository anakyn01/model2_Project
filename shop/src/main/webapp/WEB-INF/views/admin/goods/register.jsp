<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="resources/ckeditor/ckeditor.js"></script>
<jsp:include page="../../include/header.jsp" flush="false"/>
<div class="container-fluid">
<div class="row">
<div class="col-md-12">
<div class="d-flex">
<aside class="w-25">
<jsp:include page="../include/lnb.jsp" flush="false"/>
</aside>
<main class="w-75 p-5">
<h1 class="my-5">상품등록</h1>
<form method="post" autocomplete="off" enctype="multipart/form-data">
<div class="input-group">
	<label class="form-label">
	1차 분류
	</label>
	<select class="form-select category1">
		<option value="">전체</option>
	</select>
</div>
<div class="input-group my-3">
	<label class="form-label">
	2차 분류
	</label>
	<select class="form-select category2" name="cateCode">
		<option value="">전체</option>
	</select>
</div>

<div class="input-group mt-5">
<label class="form-label w-25" for="gdsName">상품명</label>
<input type="text" class="form-control w-75" id="gdsName" name="gdsName"/>
</div>

<div class="input-group mt-5">
<label class="form-label w-25" for="gdsPrice">상품가격</label>
<input type="text" class="form-control w-75" id="gdsPrice" name="gdsPrice" />
</div>

<div class="input-group mt-5">
<label class="form-label w-25" for="gdsStock">상품수량</label>
<input type="text" class="form-control w-75" id="gdsStock" name="gdsStock" />
</div>

<div class="input-group mt-5">
<label class="form-label w-25" for="gdsDes">상품소개</label>
<textarea class="form-control w-75" id="gdsDes" name="gdsDes"></textarea>
<script>
var ckeditor_config = {
		resize_enable : false,
		enterMode : CKEDITOR.ENTER_BR,
		shiftEnterMode : CKEDITOR.ENTER_P,
		filebrowserUploadUrl : "/admin/goods/ckUpload"
};
CKEDITOR.replace("gdsDes", ckeditor_config);
</script>
</div>

<div class="input-group mt-5">
	<label class="form-label w-25" for="gdsImg">이미지</label>

	<input type="file" id="gdsImg" name="file" class="form-control"/>
</div>
	<div class="select_img">
		<img src=""/>
	</div>
	<p>원본 이미지</p>
	<img src="${goods.gdsImg}" />
	<p>썸네일</p>
	<img src="${goods.gdsThumbImg}" />
<script>
$("#gdsImg").change(function(){
	if(this.files && this.files[0]){
		var reader = new FileReader;
		reader.onload = function(data){
			$(".select_img img").attr("src", data.target.result).width(500);
		}
		reader.readAsDataURL(this.files[0]);
	}
});
</script>
<style>
.select_img img {margin:20px 0;}
</style>

<%=request.getRealPath("/") %><!-- 올리는 실질 경로가 포함됨 -->

<div class="d-flex justify-content-end my-5" >
<input type="submit" class="form-cotrol btn btn-primary" value="등록"/>
</div>

</form>
</main>
<script>
// 컨트롤러에서 데이터 받기
var jsonData = JSON.parse('${category}');
console.log(jsonData);

var cate1Arr = new Array();
var cate1Obj = new Object();

// 1차 분류 셀렉트 박스에 삽입할 데이터 준비
for(var i = 0; i < jsonData.length; i++) {
 
 if(jsonData[i].level == "1") {
  cate1Obj = new Object();  //초기화
  cate1Obj.cateCode = jsonData[i].cateCode;
  cate1Obj.cateName = jsonData[i].cateName;
  cate1Arr.push(cate1Obj);
 }
}

// 1차 분류 셀렉트 박스에 데이터 삽입
var cate1Select = $("select.category1")

for(var i = 0; i < cate1Arr.length; i++) {
 cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>"
      + cate1Arr[i].cateName + "</option>"); 
}

$(document).on("change", "select.category1", function(){
	//select.category1이 변경되었다면 실행되는 함수

	 var cate2Arr = new Array();
	 var cate2Obj = new Object();
	 
	 // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
	 for(var i = 0; i < jsonData.length; i++) {
	  
	  if(jsonData[i].level == "2") {
	   cate2Obj = new Object();  //초기화
	   cate2Obj.cateCode = jsonData[i].cateCode;
	   cate2Obj.cateName = jsonData[i].cateName;
	   cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;
	   
	   cate2Arr.push(cate2Obj);
	  }
	 }
	 
	 var cate2Select = $("select.category2");
	 
	 cate2Select.children().remove();

	 /*for(var i = 0; i < cate2Arr.length; i++) {
	   cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
	        + cate2Arr[i].cateName + "</option>");
	 }*/
	$("option:selected", this).each(function(){
		var selectVal = $(this).val();
		cate2Select.append("<option value='" + selectVal + "'>전체</option>");
		
		for(var i =0; i < cate2Arr.length; i++){
			if(selectVal == cate2Arr[i].cateCodeRef){
				   cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
					        + cate2Arr[i].cateName + "</option>");
			}
		}
		
	}); 
});

</script>

</div>
</div>
</div>
</div>

<jsp:include page="../../include/footer.jsp" flush="false"/>