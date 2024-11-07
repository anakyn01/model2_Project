$(function(){
	// 컨트롤러에서 데이터 받기
var jsonData = JSON.parse('${category}');
console.log(jsonData);
var cate1Arr = new Array();//어레이 객체
var cate1Obj = new Object();//변수 담는 오브젝트


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
/*
컨트롤러에서 모델에 보낸 값인 category를 jsonData에 저장합니다. 이때 JSON.parse('${category}');가 아닌 JSON.parse("${category}"); 로,
 즉 쌍따옴표를 사용하게 되면 에러가 발생하니 주의합니다.

jsondata에서 level값이 1인 경우에만 cate1Obj에 추가하고, 
이 추가한 데이터를 cate1Arr에 추가합니다. 
이렇게 추가한 값을 cate1Select에 추가합니다.
 */
});






