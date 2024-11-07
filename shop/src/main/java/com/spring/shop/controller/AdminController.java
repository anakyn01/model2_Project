package com.spring.shop.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.shop.domain.CategoryVO;
import com.spring.shop.domain.GoodsVO;
import com.spring.shop.domain.GoodsViewVO;
import com.spring.shop.service.AdminService;
import com.spring.shop.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@Resource(name="uploadPath")//리소스로 임명
	private String uploadPath;
	
	//관리자 화면
	@GetMapping(value="/index")
	public void getIndex() throws Exception{
		logger.info("get index");
	}
	
	//상품등록
	@GetMapping(value="/goods/register")
	public void getGoodsRegister(Model model) throws Exception{
		logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category",JSONArray.fromObject(category));
		//pom.xml에 DI추가
	}
	@PostMapping(value="/goods/register")
	public String postGoodsRegister(GoodsVO vo, MultipartFile file) throws Exception{
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator+ "s"+File.separator+ "s_" + fileName);
		
		adminService.register(vo);
		
		return "redirect:/admin/index";
	}
	
	/*
	 * CategoryVO형태의 List변수 category를 선언하고 adminService.category()
	 * 호출한뒤 결과값을 카케고리에 입력 JSONArray를 이용해서 category를 JSON타입으로
	 * 변경한뒤 category라는 명칭으로 모델을 추가
	 * 이 메서드가 호출될때 모델을 jsp에 넘겨서 사용할수 있습니다
	*/
	
	//list
	@GetMapping(value="/goods/list")
	public void getGoodsList(Model model) throws Exception{
		logger.info("get goods list");
		
		List<GoodsVO> list = adminService.goodslist();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping(value="/goods/view")
	public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception{
		logger.info("get goods view");
		//GoodsVO goods = adminService.goodsView(gdsNum);
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods",goods);
	}
	
	@GetMapping(value="/goods/modify")//상품수정
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws Exception{
		logger.info("get goods modify");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods",goods);
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category",JSONArray.fromObject(category));
	}
	@PostMapping(value="/goods/modify")
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception{
		logger.info("post goods modify");
		
//새로운 파일이 등록되어있는지 확인
if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
	//기존 파일 삭제 일반 이미지와 썸네일 파일 삭제
	new File(uploadPath + req.getParameter("gdsImg")).delete();
	new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
	
	//새로 첨부한 파일을 등록
	String imgUploadPath = uploadPath + File.separator + "imgUpload";
	String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
	String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
	
	vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
	vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
} else {//새로운 파일이 등록되지 않았다면 기존 이미지를 그대로 사용
vo.setGdsImg(req.getParameter("gdsImg"));
vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
}
		adminService.goodsModify(vo);
		return "redirect:/admin/index";
	}
	
	//상품삭제
	@PostMapping(value="/goods/delete")
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception{
		logger.info("post goods delete");
		adminService.goodsDelete(gdsNum);
		return "redirect:/admin/index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
