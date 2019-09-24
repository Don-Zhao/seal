package com.seal.mail;

import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component("mailSenderUtil")
public class MailSender {
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	public void sendSimpleMail(String subject, String content, String...tos) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(tos);
		message.setSubject(subject);
		message.setText(content);
		javaMailSender.send(message);
	}
	
	public void sendHtmlMail(String subject, String content, String...tos) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
		helper.setFrom(from);
		helper.setTo(tos);
		helper.setSubject(subject);
		helper.setText(content, true);
		
		javaMailSender.send(helper.getMimeMessage());
	}
	
	public void sendTemplateMail(String subject, String template, Map<String, Object> context, String...tos) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
		helper.setFrom(from);
		helper.setTo(tos);
		helper.setSubject(subject);
		String htmlContent = this.render(template, context);
		helper.setText(htmlContent, true);
		
		javaMailSender.send(helper.getMimeMessage());
	}
	
	private String render(String template, Map<String, Object> context) {
		IContext templateContext = new Context(Locale.CHINA, context);
		return templateEngine.process(template, templateContext);
	}
}
