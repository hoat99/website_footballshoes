package com.example.service.iml;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.dto.request.MailRequest;
import com.example.dto.request.RegisterRequest;
import com.example.dto.request.UserProfileRequest;
import com.example.entity.Subscribers;
import com.example.entity.User;
import com.example.repository.SubscribersRepository;
import com.example.service.CommonService;
import com.example.service.MailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService{

    private final JavaMailSender javaMailSender;
    
    private final SubscribersRepository subscribersRepository;
	
	@Override
	public void sendText(String mailTo, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mailTo);
        message.setSubject(subject);
        message.setText(content);

        // Send Message!
        this.javaMailSender.send(message);		
	}

	@Override
	public void sendHtml(MailRequest request) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = request.getContent();

        message.setContent(htmlMsg, "text/html; charset=utf-8");


        helper.setSubject(request.getSubject());
        System.out.println(request.getMailTo());
        
        if (request.getMailTo() == "") {
			List<Subscribers> subscribers = this.subscribersRepository.findAll();
			for (Subscribers subscriber : subscribers) {
				helper.setTo(subscriber.getEmail());
		        this.javaMailSender.send(message);		
			}
		}else {
	        helper.setTo(request.getMailTo());
	        this.javaMailSender.send(message);		
		}
	}

	@Override
	public void sendMailResetPassword(String recipientEmail, String link) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setTo(recipientEmail);	     
	    String subject = "Đây là đường dẫn để reset mật khẩu";
	     
	    String content = "<p>Chào bạn,</p>"
	            + "<p>Bạn đã yêu cầu xin cấp lại mật khẩu</p>"
	            + "<p>Ấn vào link bên dưới để đổi mật khẩu</p>"
	            + "<p><a href=\"" + link + "\">Đổi mật khẩu</a></p>"
	            + "<br>"
	            + "<p>Bỏ qua email này nếu bạn nhớ mật khẩu, "
	            + "hoặc không phải bạn là người xin cấp lại mật khẩu.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    javaMailSender.send(message);		
	}

	@Override
	public void sendVerificationEmail(User user, String siteURL)
			throws MessagingException, UnsupportedEncodingException {
		String toAddress = user.getEmail();
	    String subject = "Hãy kích hoạt tài khoản của bạn";
	    String content = "Chào [[name]],<br>"
	            + "Hãy nhấn vào link bên dưới để kích hoạt tài khoản của bạn:<br>"
	            + "<h3><a href=\"[[URL]]\" target=\"_self\">Kích hoạt tài khoản</a></h3>"
	            + "Cảm ơn,<br>"
	            + "AUTHENTIC.COM.";
	     
	    MimeMessage message = javaMailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", user.getUsername());
	    String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
	     
	    content = content.replace("[[URL]]", verifyURL);
	     
	    helper.setText(content, true);
	     
	    javaMailSender.send(message);
		
	}
}
