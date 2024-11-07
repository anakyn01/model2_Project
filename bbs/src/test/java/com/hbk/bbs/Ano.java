package com.hbk.bbs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ano {
	//커멘드 객체 => 스프링MVC는 커멘드 객체의 (첫글자를 소문자로 바꾼)클래스 이름과 
	//동일한 속성 이름을 사용해서 커멘드 객체를 뷰에 전달한다
	// 커멘드 객체에 사용할 속성 이름을 변경하고 싶다면 커멘드 객체로 사용할 파라미터에 
	//@ModelAttribute 어노테이션을 적용합니다
    //모델을 통해서 컨트로러뷰에 데이터 전달하기

	
	
	//또다른 방법은 @RequestParam을 사용한다
	@PostMapping("/register/step3")
	public String handleStep3(@RequestParam(value = "agree", defaultValue="false") Boolean agree) {
		if (!agree) {
			return "register/step";
		}
		return "register/step3";
	}
	//스프링 MVC는 파라미터 타입에 맞게  String값을 리턴한다 위에 코드는 agree요청 파라미터 값을 읽어와서 Boolean타입으로 반환해서 
	//agree파라미터에 전달한다
	@PostMapping("/register/step4")
	public String handleStep4(@ModelAttribute("formData") RegisterRequest regReq) {
			return "/register/step4";
	}
	
	
	
	@PostMapping("/register/step2")
	public String handleStep2(HttpServletRequest request) {
		String agreeParam = request.getParameter("agree");
		if (agreeParam == null || !agreeParam.equals("true")) {
			return "register/step";
		}
		return "register/step2";
	}/*
	POST방식만 처리하는 메서드 이다웹브라우저 에서 직접 주소를 입력할때 사용하는 get은 처리하지 않는다
	405코드 방식에 맞지 않는..
	이런구조에서 에러메세지 표시가 아니라 알맞게 이동하는 것이 리다이렉트 이다
	*/
	
	
	//요청 파라미터 접근 => 컨트롤러 메서드에서 요청파라미터를 사용하는 첫번째 방법은
	//HttpServletRequest를 직접이용한다
	@RequestMapping("/register/step")
	public String handleStep() {
		return "register/step";
	}//1) 특정 요청URL을 처리할 코드 2)처리 결과를 HTML과 같은 형식으로 응답하는 코드
//스프링 MVC는 별도 설정이 없으면 GET과 POST방식에 상관없이 @RequestMapping에서 지정한 
//경로와 일치하는 요청을 처리한다
//GetMapping과 PostMapping은 스프링 4.3버전에서 추가된것
}
/*
요청 매핑
커맨드 객체
폼 태그 
모델
*/
