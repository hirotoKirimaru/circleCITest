package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ResponseBody
public class LoginController {

	@RequestMapping("/")
	public String index() {		
		return "Ç±ÇÒÇ…ÇøÇÕÅI";
	}
}
