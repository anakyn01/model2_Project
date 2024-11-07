package com.cal.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
	@GetMapping("/blog/")
	public String home() {
		return "home";	
	}

	@GetMapping("/create")
	public String create() {
		return "blog/create";
	}
	

}
