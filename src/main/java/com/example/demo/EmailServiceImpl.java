/*package com.example.demo;

import java.io.File;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ws.mime.MimeMessage;

@Service
public class EmailServiceImpl  implements EmailService
{
	
	@Autowired private JavaMailSender javaMailSender;
	
	String sender = "anushreepure02@gmail.com";
	

	public String sendMail(EmailDetails details)

	{		
		try 
		{	 
			
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
            
            javaMailSender.send(mailMessage);
            
            return "Mail Sent Successfully...";
            }
			catch (Exception e)
		    {
            return "Error while Sending Mail";
		    }
	}

	
		
	}*/

