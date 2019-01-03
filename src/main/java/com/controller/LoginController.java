package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	@PostMapping("/login")
	public String login() {
		System.out.println("ログインボタン");
		
		return "index";
	}
}
