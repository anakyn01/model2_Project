package com.spring.pagenation.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pagenation.domain.BoardVO;
import com.spring.pagenation.domain.Page;
import com.spring.pagenation.domain.ReplyVO;
import com.spring.pagenation.service.BoardService;
import com.spring.pagenation.service.ReplyService;





/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	@Inject
	private BoardService service;
	
	@Inject
	private ReplyService replyService;
	

	@GetMapping(value = "/")
	public String home() {	
		return "home";
	}
	
	@GetMapping(value ="/board/list")
	public void getList(Model model) throws Exception{
		List<BoardVO> list = null;
		list = service.list();
		model.addAttribute("list",list);
	}
	//쓰기 라우팅
	@GetMapping("/board/write")
	public void getWirte() throws Exception{		
	}
	//모델 쓰기
	@PostMapping("/board/write")
	public String postWrite(BoardVO vo) throws Exception{
		service.write(vo);
		return "redirect:/board/list";
	}
	//read
	@GetMapping("/board/view")
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception{
		BoardVO vo = service.view(bno);
		model.addAttribute("view", vo);
		
		
		// 댓글 조회
		List<ReplyVO> reply = null;
		reply = replyService.list(bno);
		model.addAttribute("reply", reply);

	}
	
	//게시물 수정
	@GetMapping("/board/modify")
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception{
		BoardVO vo = service.view(bno);
		model.addAttribute("view", vo);
	}
	@PostMapping("/board/modify")
	public String postModify(BoardVO vo)throws Exception{
		service.modify(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	//게시물 삭제
	@GetMapping("/board/delete")
	public String getDelete(@RequestParam("bno") int bno)throws Exception{
		service.delete(bno);
		return "redirect:/board/list";
	}
	
	//게시물 목록 + 페이징 추가
	@GetMapping("/board/listPage")
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception{
	//page class만든후
		Page page = new Page();//Page형의 page변수 생성
		
		page.setNum(num);
		page.setCount(service.count());
		//Page에 현재 페이지인 num, 게시물의 총갯수인 service.count()를 넣어주면 클래스 내부에서 계산을 해줍니다
		//이렇게 계산된 데이터는 page.getDisplayPost()처럼 호출하여 사용할수 있습니다
		
		List<BoardVO> list = null;
		list = service.listPage(page.getDisplayPost(), page.getPostNum());
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		
		/*기존 게시물 총갯수
		int count = service.count();
		//한 페이지에 출력할 게시물 갯수
		int postNum = 10;
		// 하단 페이징 번호([게시물 총겟수 % 한페이지에서 출력할 겟수]의 올림)
		int pageNum = (int)Math.ceil((double)count/postNum);
		//출력할 게시물 현재페이지를 기준으로 10개의 데이터를 출력한다
		int displayPost = (num -1) * postNum;
		
		//2단계
		//한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;
		//표시되는 페이지 번호중 마지막 번호
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		//표시되는 페이지 번호중 첫번째 번호
	    int startPageNum = endPageNum - (pageNum_cnt - 1);
	/*
	현재 페이지번호가 8번 
	한번에 표시할 페이지 번호의 갯수인 10으로 나눕니다  8 / 10 = 0.8
	0.8 => 1
	1을 한번에 표시할 페이지 번호의 갯수인 10을 곱하면 10이 됩니다
	
	현재 페이지번호가 41번 41/10 =4.1 올림 => 4.1 => 5
	5에 10을 곱하면 50 이이유는 꽉안채워도 공식에 맞게 보여야 해서
	
마지막 페이지 번호 = ((올림)(현재페이지 번호/한번에 표시할 페이지 번호의 갯수)) * 한번에 표시할 페이지 번호의 갯수
10 => 0
50 => 40
여기에 1을 더하면 각페이지에 시작번호가 됩니다

시작 페이지 = 마지막 페이지 번호 - 한번에 표시할 페이지 번호의 갯수 + 1

	    //3단계 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}

112 하단 1-10, 11-12 한번에 표시할 페이지번호 10 현제 페이지가 11일 경우
[ ((올림)(11 / 10)) * 10 => (올림)1.1 * 10 => 2 * 10 = 20 ] 이 됩니다.
즉, 13 ~ 20까지 없어야할 페이지 번호가 출력됩니다.
# 2차 계산
여기에서 게시물 총 갯수와 한번에 표시될 페이지 번호의 갯수를 이용해 재계산합니다.
[ (올림)112 / 10 => (올림)11.2 => 12 ] 가 됩니다.

1차 계산한 마지막 페이지 번호는 20이며, 2차로 계산한 마지막 페이지 번호는 12입니다.
이 둘을 비교해서 만약 1차 계산이 더 크다면, 2차로 계산한 값을 넣어줍니다.
    
		boolean prev = startPageNum == 1 ? false : true;
	    boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		
		List<BoardVO> list = null;
		list = service.listPage(displayPost, postNum);
		model.addAttribute("list",list);
		model.addAttribute("pageNum",pageNum);
		
		//시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		//이전 및 다음
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);*/
	}
	
	//게시물 목록 + 페이징 추가  + 검색
	@GetMapping("/board/listPageSearch")
		public void getListPageSearch(Model model, @RequestParam(defaultValue="1") int num, 
				@RequestParam(value="searchType", required = false, defaultValue="title") String searchType, 
				@RequestParam(value="keyword", required = false, defaultValue="") String keyword) throws Exception{
		// 매개변수에 검색관련 추가를 하여 URL을 통해 searchType, keyword를 받아낼수 있도록 함
		//value[데이터의 키], required[필수 여부], defaultValue[데이터가 들어오지 않을 대신할 기본값]
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(service.searchCount(searchType, keyword));
		
		//검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		
		List<BoardVO> list = null;
		list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		
		//
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
