package kyobo.kr.booksmall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksController {

	private static final Logger logger = LoggerFactory.getLogger(BooksController.class);
	
	//메인 페이지 이동
	@GetMapping(value="/main")
	public void mainPageGET() {
		logger.info("메인 페이지 진입");
	}
}
