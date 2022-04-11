package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.model.Utility;
import com.example.service.MailService;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;

@Controller
@RequiredArgsConstructor
public class ForgotPasswordController {

	private final UserService userService;
	
	private final MailService mailService;
	
	@GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
		return "user/forgot_password_form";
    }
 
    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) {
    	String email = request.getParameter("email");
    	String token = RandomString.make(30);
    	
    	try {
			userService.updateResetPasswordToken(token, email);
			String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" +token;
			this.mailService.sendMailResetPassword(email, resetPasswordLink);
			model.addAttribute("message", "Chúng tôi đã gửi liên kết để reset lại mật khẩu vào email của bạn. Hãy kiểm tra.");
		} catch (Exception e) {
			model.addAttribute("error", "Không tìm thấy tài khoản nào có email như trên");
		}
    	return "user/forgot_password_form";
    }
 
     
    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
    	User user = userService.getByResetPasswordToken(token);
    	model.addAttribute("token", token);
    	if (user == null) {
			model.addAttribute("message", "Mã xác nhận không hợp lệ");
			return "user/message";
    	}
    	return "user/reset_password_form";
    }
     
    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {
    	String token = request.getParameter("token");
    	String password = request.getParameter("password");
    	
    	User user = userService.getByResetPasswordToken(token);
    	model.addAttribute("title", "Reset mật khẩu");
    	
    	if (user == null) {
			model.addAttribute("massage", "Mã xác thực không hợp lệ!");
			return "user/message";
		}else {
			userService.updatePassword(user, password);
			model.addAttribute("message", "Đổi mật khẩu thành công.");
		}
		return "user/message";
    }
	
}
