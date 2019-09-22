package com.seal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SealController {
	
	@RequestMapping("/login")
	public String login() {
		return "index";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}
