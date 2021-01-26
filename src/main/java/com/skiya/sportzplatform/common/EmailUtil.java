package com.skiya.sportzplatform.common;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Component
public class EmailUtil {

	private final Logger log = LoggerFactory.getLogger(EmailUtil.class);
	
	@Autowired
	@Value("${sendgrid.api.key}")
	private String sendAPIKey;
	
	@Autowired
	@Value("${email.from.address}")
	private String fromAddress;

	public void sendSimpleEmail(String toAddress, String subject, String message) {

		Email from = new Email(fromAddress);
		Email to = new Email(toAddress);

		Content content = new Content("text/html", message);
		Mail mail = new Mail(from, subject, to, content);
		
		log.debug("Send API Key" + sendAPIKey);

		SendGrid sg = new SendGrid(sendAPIKey);

		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			log.debug(""+response.getStatusCode());
			log.debug(response.getBody());
			log.debug(""+response.getHeaders());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
