package net.guides.springboot.todomanagement.utill;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import net.guides.springboot.todomanagement.config.Mail;




@Service
public class EmailSendingUtill {

	 @Autowired
     JavaMailSender mailSender;
	 
//	 @Autowired
//     @Qualifier("emailConfigBean")
//     private Configuration emailConfig;
	 
	 public void sendEmail() throws IOException {
		    Mail mail = new Mail();
	        mail.setMailFrom("plashunnaidu@yahoo.com");
	        mail.setMailTo("plakshunnaidu@gmail.com");
	        mail.setMailSubject("Spring Boot - Email Example");
	        mail.setMailContent("Hello");
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        try {
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setSubject(mail.getMailSubject());
	            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), mail.getSenderName()));
	            mimeMessageHelper.setTo(mail.getMailTo());
	            mimeMessageHelper.setText(mail.getMailContent());
	 
	            mailSender.send(mimeMessageHelper.getMimeMessage());
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	}
	 
	 
	 
//	    public void sendEmail(ToysLoginFormsDTO toysLoginFormsDTO) throws MessagingException, IOException, TemplateException {
//	        Mail mailModels = new Mail();
//	        Map<String, String> mode = new HashMap<String, String>();
//	        mode.put("registerName", toysLoginFormsDTO.getRegisterName());
//	        mailModels.setModel(mode);
//	        MimeMessage message = mailSender.createMimeMessage();
//	        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
//
//	        mimeMessageHelper.addInline("logo.png", new ClassPathResource("classpath:/Personal_Budget_Form.pdf"));
//
//	        
//	        Template template = emailConfig.getTemplate("registationEmail.html");
//	        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, mailModels.getModel());
//	        mimeMessageHelper.setTo(toysLoginFormsDTO.getRegisterEmail());
//	        mimeMessageHelper.setText(html, true);
//	        mimeMessageHelper.setSubject("Welcome To Toys Home");
//	        mimeMessageHelper.setFrom(new InternetAddress("naidu20061989@gmail.com", toysLoginFormsDTO.getRegisterName()) );
//	        mailSender.send(message);
//
//	    }
}
