package com.green.ex08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController { // Action 클래스

	@RequestMapping("/hello")
	public String hello(Model model, @RequestParam("name") String name) {
		
//		model.addAttribute("name", "Spring!");
		model.addAttribute("name", name);
		
		return "hello";	// /WEB-INF/views/hello.jsp
	}
}