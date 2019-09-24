package com.seal.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seal.activemq.Producer;
import com.seal.model.MailModel;

@Controller
public class SealController {
	
	@Autowired
	private Producer producer;
	
	@RequestMapping("/login")
	public String login() {
		return "index";
	}
	
	@RequestMapping("/home")
	public String home() {
//		mailService.sendMail("zhao", "this is a simple message", "zhaojiahong@zhaojiahong.com");
		// mailService.sendMail("welcome", map, "zhaojiahong@zhaojiahong.com");
		Map<String, Object> map = new HashMap<>();
		map.put("username", "zhaojiahong");
		MailModel mailModel = new MailModel();
		mailModel.setSubject("欢迎邮件");
		mailModel.setTemplate("welcome");
		mailModel.setHtmlText(true);
		mailModel.setTemplateText(true);
		mailModel.setToEmails(new String[] {"zhaojiahong@zhaojiahong.com", "lilinlin@zhaojiahong.com"});
		mailModel.setParams(map);
		producer.sendMessage(new ActiveMQQueue("seal/mail"), mailModel);
		
		return "home";
	}
}
