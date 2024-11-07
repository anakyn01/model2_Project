$(function(){
 var formObj = $("form[role='form']");
 
	 // 수정 버튼 클릭
	 $("#modity_btn").click(function(){
	  
	  formObj.attr("action", "http://localhost:8080/port/board/modify?bno="+ $("#bno").val());
	  formObj.attr("method", "post");  
	  formObj.submit();     
	  
	 });
	 
	 
	 // 삭제 버튼 클릭
	 $("#delete_btn").click(function(){
	  
	  formObj.attr("action", "http://localhost:8080/port/board/delete");
	  formObj.attr("method", "get");  
	  formObj.submit();
	  
	 });

   // 취소 버튼 클릭
    $("#cancel_btn").click(function(){   
     formObj.attr("action", "http://localhost:8080/port/board/read?bno=" + $("#bno").val());
     formObj.attr("method", "get");  
     formObj.submit();
    });

    $('.userId').on("propertychange change keyup paste input", function(){
	var userId = $('.userId').val();
	var data = {userId : userId}
	
	$.ajax({
		type:"post",
		url:"./memberIdChk",
		data : data,
		success : function(result){
			if(result != 'fail'){
				$('.id_input_re_1').css("display","inline-block");
				$('.id_input_re_2').css("display","none")
			}else{
				$('.id_input_re_2').css("display","inline-block");
				$('.id_input_re_1').css("display","none");
			}
		}
	})
	})


	
})