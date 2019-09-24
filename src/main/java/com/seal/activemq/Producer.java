package com.seal.activemq;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.seal.model.MailModel;

@Service("producer")
public class Producer {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	public void sendMessage(Destination destination, MailModel mailModel) {
		jmsMessagingTemplate.convertAndSend(destination, mailModel);
	}
	
}
