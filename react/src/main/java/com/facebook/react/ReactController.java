package com.facebook.react;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.react.service.ReactService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReactController {
	
	@Autowired(required=true)
	ReactService reactService;//컨트롤러에 서비스 주입
	
	private static final Logger logger = LoggerFactory.getLogger(ReactController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping(value="/sub/create")
	public String getCreate() {
		return "/sub/create";
	}
	@PostMapping(value="/sub/create")
	public String postCreate(@RequestParam Map<String, Object> map) {
		int reactContSeq = this.reactService.create(map);
		return "redirect:/sub/read/" + String.valueOf(reactContSeq);
	}
	
	//read
	@GetMapping(value="/sub/read/{reactContSeq}")
	public String getRead(@PathVariable("reactContSeq") int reactContSeq, Model model) {
		Map<String, Object> reactCont = this.reactService.read(reactContSeq);
		model.addAttribute("reactCont", reactCont);
		return "sub/read";
	}
	
	
	@GetMapping(value="/sub/list")
	public String getList() {
		return "/sub/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
