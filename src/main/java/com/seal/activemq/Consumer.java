package com.seal.activemq;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.seal.mail.MailSender;
import com.seal.model.MailModel;

@Component
public class Consumer {
	
	@Autowired
	private MailSender mailSenderUtil;
	
	@JmsListener(destination="seal/mail")
	public void sendMail(MailModel mailModel) {
		try {
			if (!mailModel.isHtmlText() && !mailModel.isTemplateText()) {
				mailSenderUtil.sendSimpleMail(mailModel.getSubject(), mailModel.getContent(), mailModel.getToEmails());
			} else if (mailModel.isHtmlText() && !mailModel.isTemplateText()) {
				mailSenderUtil.sendHtmlMail(mailModel.getSubject(), mailModel.getContent(), mailModel.getToEmails());
			} else if (mailModel.isTemplateText()) {
				mailSenderUtil.sendTemplateMail(mailModel.getSubject(), 
						mailModel.getTemplate(), 
						mailModel.getParams(), 
						mailModel.getToEmails());
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
