package com.spring.pagenation.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pagenation.domain.ReplyVO;
import com.spring.pagenation.service.ReplyService;

@Controller
public class ReplyController {
	
	@Inject
	private ReplyService replyService;
	
	@PostMapping("/reply/write")
	public String posttWrite(ReplyVO vo) throws Exception{
		replyService.write(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	//댓글 단일 조회 (수정페이지)
	@GetMapping(value="/reply/modify")
	public void getModify(@RequestParam("bno") int bno, @RequestParam("rno") int rno, Model model) throws Exception{
		ReplyVO vo = new ReplyVO();
		vo.setBno(bno);
		vo.setRno(rno);
		ReplyVO reply = replyService.replySelect(vo);
		model.addAttribute("reply", reply);
	}
	@PostMapping(value="/reply/modify")
	public String postModify(ReplyVO vo) throws Exception{
		replyService.modify(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	
	
	
	
	

}
