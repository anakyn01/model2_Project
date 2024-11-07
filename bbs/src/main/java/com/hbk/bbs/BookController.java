package com.hbk.bbs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;//네임스페이스
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //콘트롤러 어노테이션
public class BookController {
	
	@Autowired//스프링에서 의존성을 자동으로 주입할때 사용하는 어노테이션
	BookService bookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";	
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)//url주소를 얻음
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	
	//모델
	
	/*
	쿼리스트링 : 주소창을 통해서 파라미터가 서버로 전달되는 형태를 쿼리스트링이라 부른다
	HTTP규격에서 쿼리스트링은 URL(uniform resource locator)끝에 ?로 시작한다
	
	/sample/test?a=1&b=2
	url : /sample/test
	쿼리스트링 : ?a=1&b=2
	쿼리스트링 시작 : ?
	쿼리스트링 항목구분 : &
	쿼리스트링 항목들 : a=1, b=2
	URI = /sample/test?a=1&b=2
	*/
	//view detail
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		//@RequestParam를 통해서 쿼리스트링 파라미터를 읽을수 있다 스프링은 http메소드를 구분하지 않고 파라미터를 GET,POST동일한 방법으로 읽을수 있게 한다
		Map<String, Object> detailMap = this.bookService.detail(map);
		//데이터 베이스에서 조회한 결과를 detailMap변수에 담는다
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		//ModelAndView 타입객체 mav에 뷰로 전달할 데이터를 담는다 data란 이름으로 쿼리 결과를 담는다
		String bookId = map.get("bookId").toString();
		//pk인 bookId도 mav객체에 담는다
		mav.addObject("bookId",bookId);
		//이때 bookId의 값은 HTTP쿼리스트링 파라미터 가지고 왔다
		mav.setViewName("/book/detail");
		return mav;
		
	}
	//수정화면 메소드 1) 기존있던 정보 불러오기
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.bookService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("/book/update");
		return mav;
	}
	//수정화면 메소드2) 수정하기
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView();
		
		//dao에서 한개의 행을 영향 받앗는지에 대한 검사
		boolean isUpdateSuccess = this.bookService.edit(map);
		if (isUpdateSuccess) {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId="+bookId);
			//정상적으로 데이터가 갱신되었을 경우 확인을 위해서 상세페이지로 이동
		}else {//아니라면 history.back
		mav = this.update(map);	
		}	
		return mav;//위에 사항에 맞게 리턴
	}//수정화면에서 수정기능으로 보내주는 파라미터는 총4개 get = bookid 나머지 폼태그로 전달되는 title, category, price
	//스프링은 @RequestMapping get post를 구분하지않고 무조건 파라미터에 넣어준다
	
	//삭제기능 콘트롤러 메소드
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object>map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isDeleteSuccess = this.bookService.remove(map);
		//삭제가 성공했는지 확인한다
		if(isDeleteSuccess) {//성공하면 목록으로 리턴
			mav.setViewName("redirect:/list");
		}else {//삭제가 실패하면 다시 상세페이지로 이동한다
			String bookId = map.get("bookid").toString();
			mav.setViewName("redirect:/detail?bookId="+bookId);
		}
		return mav;
	}
	
	//목록 콘트롤러 메소드 추가
	@RequestMapping(value = "list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>>list = this.bookService.list(map);
		//목록을 데이터베이스에서 가지고 온다
		ModelAndView mav = new ModelAndView(); 
		//데이터를 뷰에 전달할수 있게 mav객체에 넣는다
		mav.addObject("data", list);
		//라우팅
		if(map.containsKey("keyword")) {//파라미터가 있는지 검사
		mav.addObject("keyword",map.get("keyword"));
		//파라미터가 있다면 뷰에 키워드를 전달한다
		}
	    mav.setViewName("/book/list");//jsp파일이 존제하는 path지정
	    return mav;
	}
	
	/*스프링 레퍼런스*/
	@GetMapping("/ref/1_di")
	public String di() {
		return "/ref/1_di";
	}
	@GetMapping("/ref/2_auto")
	public String auto() {
		return "/ref/2_auto";
	}
	
	
	
	
	
	
	
	
	
	

}
