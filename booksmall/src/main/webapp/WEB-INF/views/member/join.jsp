<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>join</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-3">회원가입</h1>
<form id="join_form" method="POST">
<div class="input-group mb-3">
    <label class="form-label">아이디</label>
    <input type="text" class="form-control id_input" name="memberId"/>
</div>
    <div class="id_input_re_1">사용 가능한 아이디 입니다</div>
    <div class="id_input_re_2">아이디가 이미 존재합니다</div>
<style>
.id_input_re_1{
color:green; display:none;
}
.id_input_re_2{
color:red; display:none;
}
#mail_check_input_box_false{
background-color:#ebebe4;
}
#mail_check_input_box_true{
background-color:white;
}
.correct{color:green;}
.incorrect{color:red;}
</style>
<div class="input-group mb-3">
    <label class="form-label">비밀번호</label>
    <input type="password" class="form-control" name="memberPw"/>
</div>
<div class="input-group mb-3">
    <label class="form-label">이름</label>
    <input type="text" class="form-control" name="memberName"/>
</div>
<div class="input-group mb-3 mail_input_box">
    <label class="form-label">이메일</label>
    <input type="text" class="form-control mail_input" name="memberMail"/>
</div>
<div class="input-group mb-3 ">
	<div class="mail_check_input_box" id="mail_check_input_box_false">
    	<input type="text" 
    	class="form-control mail_check_input" 
    	disabled="disabled"
    	/>
    </div>
    <button class="mail_check_button btn btn-outline-success">
    인증번호 전송
    </button>
    <div id="mail_check_input_box_warn"></div>
</div>
<div class="input-group mb-3">
    <label class="form-label">주소</label>
    <input type="text" class="form-control address_input_1" name="memberAddr1" readonly="readonly"/>
    <button class="btn btn-outline-success address_button" onclick="execution_daum.address()">
    주소찾기
    </button>
</div>
<div class="input-group mb-3">
    <input type="text" class="form-control address_input_2" name="memberAddr2" readonly="readonly"/>
</div>
<div class="input-group mb-3">
    <input type="text" class="form-control address_input_3" name="memberAddr3" readonly="readonly"/>
</div>

<div>
<input type="submit" class="join_button"/>
</div>
</form>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//인증번호 일치 야부 검사기능
var code = ""; //이메일전송 인증번호 저장위한 코드

// 유효성 검사 통과유무 변수
var idCheck = false;
var idckCheck = false;
var pwCheck = false;
var pwckCheck = false;
var pwckcorCheck = false;
var nameCheck = false;
var mailCheck = false;
var mailnumCheck = false;
var addressCheck = false;

$(document).ready(function(){
//회원가입버튼을 클릭할때 (회원가입 기능 작동)
    $(".join_button").click(function(){
        $("#join_form").attr("action","/member/join");
        $("#join_form").submit();
    });
});
//아이디 중복 검사
$('.id_input').on("propertychange change keyup paste input", function(){
	var memberId = $('.id_input').val();//.id_input에 입력되는 값
	var data = {memberId : memberId}//컨트롤에 넘길 데이터 이름 : 데이터('.id_input에 입력되는값')
	
	//Asynchronous JavaScript and XML => 비동기 웹제작을 위한 웹 개발 비법
	$.ajax({
	 type : "POST",
	 url :"/member/memberIdChk",
	 data : data,
	 success : function(result){
		 console.log("성공 여부" + result);
		 
		 if(result != 'fail'){
			 $('.id_input_re_1').css("display","block");
			 $('.id_input_re_2').css("display","none");
		 }else{
			 $('.id_input_re_2').css("display","block");
			 $('.id_input_re_1').css("display","none");
		 }
	 }
	});
});

//인증번호 이메일 전송
$(".mail_check_button").click(function(){
	//입력한 이메일
	var email = $(".mail_input").val();
	var checkBox = $(".mail_check_input"); //인증번호 입력란
	var boxWrap = $(".mail_check_input_box")//인증번호 입력란 박스
	
	$.ajax({
		type:"GET",
		url:"mailCheck?email=" + email,
        success:function(data){
        checkBox.attr("disabled",false);
        boxWrap.attr("id","mail_check_input_box_true");
        }
	})
});
//인증번호 비교
$(".mail_check_input").blur(function(){
	var inputCode = $(".mail_check_input").val(); //입력코드
	var checkResult = $("#mail_check_input_box_warn");//비교 결과
	
	if(inputCode == code){
		checkResult.html("인증번호가 일치 합니다");
		checkResult.attr("class", "correct");
	}else{
		checkResult.html("인증번호를 다시 확인해 주세요");
		checkResult.attr("class", "incorrect");
	}
});
//다음주소연동
function execution_daum_address(){
	
	new daum.Postcode({
		oncomplete: function(data){
			
			var addr = '';
			var extraAddr = '';
			
			if (data.userSelectedType === 'R') {//도로명 선택
				addr = data.roadAddress;
			}else {//지번
				addr = data.jibunAddress;
			}
			
			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                addr += extraAddr;
            
            } else {
                addr += ' ';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            /*document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;*/
            $(".address_input_1").val(data.zonecode);
            $(".address_input_2").val(addr);
            $(".address_input_3").attr("readonly",false);
          
            $(".address_input_3").focus();

			
		}
	}).open();
	
}












</script>
</div>
</div>
</div>



</body>
</html>