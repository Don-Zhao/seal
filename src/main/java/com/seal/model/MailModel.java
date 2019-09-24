package com.seal.model;

import java.io.Serializable;
import java.util.Map;

public class MailModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String subject;
	
	private String[] toEmails;
	
	private String template;
	
	private String content;
	
	private boolean htmlText;
	
	private boolean templateText;
	
	private Map<String, Object> params;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String[] getToEmails() {
		return toEmails;
	}

	public void setToEmails(String[] toEmails) {
		this.toEmails = toEmails;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isHtmlText() {
		return htmlText;
	}

	public void setHtmlText(boolean htmlText) {
		this.htmlText = htmlText;
	}

	public boolean isTemplateText() {
		return templateText;
	}

	public void setTemplateText(boolean templateText) {
		this.templateText = templateText;
	}
}
