package com.javatechnology.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String to, String subject, String text) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setText(text);
		mailMessage.setSubject(subject);
		mailMessage.setFrom("javatechnology.github@gmail.com");
		mailSender.send(mailMessage);
	}
	
	public void sendEMailWithAttachment(String to, String subject, String text,String attachment) {
		MimeMessage attachmentEmail=mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(attachmentEmail, true);
			helper.setText(text);
			helper.setTo(to);
			helper.setSubject(subject);
			FileSystemResource resource= new FileSystemResource(new File(attachment));
			helper.addAttachment("Invoice", resource);
			mailSender.send(attachmentEmail);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
