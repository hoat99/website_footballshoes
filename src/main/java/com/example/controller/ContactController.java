package com.example.controller;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.request.MailRequest;
import com.example.service.CommonService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContactController {

	private final CommonService commonService;
	
	@GetMapping("/contact")
	public String contactPage(Model model) {
		this.commonService.getCommonObj(model);
		return "user/contact";
	}
	
	@PostMapping("/send-mail")
    public String sendMail(MailRequest request) throws MessagingException {
        this.commonService.sendMail(request);
        return "redirect:/contact";
    }
	
}
