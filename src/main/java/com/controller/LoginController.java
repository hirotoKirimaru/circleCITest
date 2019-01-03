package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("ログインボタン");
		
		return "index";
	}
	
	@RequestMapping("/top")
	public String top() {
		System.out.println("ログインボタン2");
		
		return "top";
	}
}
