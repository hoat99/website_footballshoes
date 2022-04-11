package com.example.dto.request;

import java.util.Objects;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RegisterRequest {

	@NotBlank(message = "This entry cannot be left blank")
    private String username;

    @NotBlank(message = "This entry cannot be left blank")
    private String password;

    @NotBlank(message = "This entry cannot be left blank")
    private String repeatPassword;

    private String name;
    
    private String gender;
    
    private String phone;
    
    private String verificationCode;

    @NotBlank(message = "This entry cannot be left blank")
    @Email(message = "Wrong email format, please check again!")
    private String email;

    @AssertTrue(message = "The password is not the same, please check again")
    private boolean isValidPassword() {
        return Objects.nonNull(this.password) && this.password.equals(this.repeatPassword);
    }
	
	
}
