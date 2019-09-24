package com.seal.service;

import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seal.mail.MailSender;

@Service
public class MailService {
	
	@Autowired
	private MailSender mailSenderUtil;
	
	public void sendMail(String subject, String content, String...tos) {
		mailSenderUtil.sendSimpleMail(subject, content, tos);
	}
	
	public void sendMail(String template, Map<String, Object> context, String...tos) {
		try {
			mailSenderUtil.sendTemplateMail("welcome", template, context, tos);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
