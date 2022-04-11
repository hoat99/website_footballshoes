package com.example.api;

import com.example.dto.request.FirebaseTokenRequest;
import com.example.dto.request.MailRequest;
import com.example.dto.request.NotificationRequest;
import com.example.dto.request.ProductRatingRequest;
import com.example.dto.request.SubscribersRequest;
import com.example.dto.request.UserProfileRequest;
import com.example.entity.FirebaseToken;
import com.example.service.CartService;
import com.example.service.CommonService;
import com.example.service.FireBaseService;
import com.example.service.MailService;
import com.example.service.ProductRatingService;
import com.example.service.UserService;
import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BaseAPI {

    private final FireBaseService firebaseService;

    private final MailService mailService;
    
    private final CommonService commonService;
    
    private final CartService cartService;
    
    private final ProductRatingService productRatingService;
    
    private final UserService userService;

    @PutMapping("/register-token")
    public FirebaseToken registerToken(@RequestBody FirebaseTokenRequest tokenRequest) {
        return this.firebaseService.saveToken(tokenRequest);
    }

    @PostMapping("/send-notification")
    public String sendNotification(@RequestBody NotificationRequest notificationRequest, @RequestParam("token") String token) {
        return this.firebaseService.sendNotification(token, notificationRequest);
    }

    @PostMapping("/send-batch-notification")
    public int sendBatchNotification(@RequestBody NotificationRequest notificationRequest) throws FirebaseMessagingException {
        return this.firebaseService.sendAllNotification(notificationRequest);
    }

    @PostMapping("/send-mail")
    public void sendMail(@RequestBody MailRequest request) throws MessagingException {
        this.mailService.sendHtml(request);
    }
    
    @PostMapping("/subscribe")
    public void subscribe(@RequestBody SubscribersRequest subscribersRequest){
        this.commonService.createSubscriber(subscribersRequest);
    }
    
    @PostMapping("/update-user")
    public void updateUser(UserProfileRequest request){
        this.userService.updateUser(request);
    }
    
    @PostMapping("/add-to-cart")
    public void addToCart(@RequestParam("idProduct") Long idProduct, Principal principal, HttpServletResponse response){
        System.out.println(idProduct);
    	this.cartService.addProductToCart(idProduct, principal.getName());
        response.addHeader("response", "success");
    }
    
    @DeleteMapping("/delete-item")
    public void deleteItem(@RequestParam("idProduct") Long idProduct, HttpServletResponse response){
        System.out.println(idProduct);
    	this.cartService.deleteCart(idProduct);
        response.addHeader("response", "success");
    }
    
    @PostMapping("/rating")
    public void doRating(@RequestBody ProductRatingRequest productRatingRequest, HttpServletResponse response, Principal principal) {
    	System.out.println(productRatingRequest);
    	this.productRatingService.doRating(productRatingRequest,principal.getName());
        response.addHeader("response", "success");
    }
}
