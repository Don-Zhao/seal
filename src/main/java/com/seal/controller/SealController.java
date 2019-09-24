package com.seal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seal.service.MailService;

@Controller
public class SealController {
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping("/login")
	public String login() {
		return "index";
	}
	
	@RequestMapping("/home")
	public String home() {
//		mailService.sendMail("zhao", "this is a simple message", "zhaojiahong@zhaojiahong.com");
		Map<String, Object> map = new HashMap<>();
		map.put("username", "zhaojiahong");
		mailService.sendMail("welcome", map, "zhaojiahong@zhaojiahong.com");
		return "home";
	}
}
