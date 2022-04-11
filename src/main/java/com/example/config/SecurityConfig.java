package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.security.service.CustomOAuth2UserService;
import com.example.security.service.UserDetailServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailServiceImpl userDetailService;
	
	private final CustomOAuth2UserService customOAuth2UserService;
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Thiết lập service tìm kiếm user và đăng ký thuật toán băm mật khẩu
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//            .and()
//            .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//            .and()
//            .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // nếu enable csrf thì chức năng logout bắt buộc phải là POST request
        http.csrf().disable();

        http
                .authorizeRequests()         
                .antMatchers("/", "/login", "/register","/oauth2/**","/reset_password**","/forgot_password").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/cart.html").hasRole("USER")
                .antMatchers("/css/**","/js/**","/vendor/**", "/img/**").permitAll()
                .anyRequest().permitAll()
                .and().exceptionHandling().accessDeniedPage("/")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID").invalidateHttpSession(true).permitAll()
                .and().exceptionHandling().accessDeniedPage("/403")
                .and()
                .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?errorSocial=true")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }

}
