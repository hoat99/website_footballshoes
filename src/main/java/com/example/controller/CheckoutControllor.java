package com.example.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.constant.ConfigVNPay;
import com.example.dto.request.OrderRequest;
import com.example.entity.Cart;
import com.example.entity.Order;
import com.example.entity.OrderInfo;
import com.example.entity.OrderInfoID;
import com.example.entity.PaymentInfo;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.repository.CartRepository;
import com.example.repository.OrderInfoRepository;
import com.example.repository.OrderRepository;
import com.example.repository.PaymentInffoRepository;
import com.example.repository.StatusRepository;
import com.example.repository.UserRepository;
import com.example.service.CartService;
import com.example.service.CommonService;
import com.example.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CheckoutControllor {

	private final UserService userService;
	
	private final CartService cartService;
	private final CommonService commonService;
	
	private final OrderRepository orderRepository;
	
	private final PaymentInffoRepository paymentInffoRepository;
	
	private final StatusRepository statusRepository;
	
	private final OrderInfoRepository orderInfoRepository;
	
	private final UserRepository userRepository;
	
	private final CartRepository cartRepository;
	

	@GetMapping("/checkout")
	public String checkoutPage(Principal principal, Model model, RedirectAttributes redirectAttributes) {
		User user = this.userService.getUser(principal.getName());
		model.addAttribute("user", user);
		
		List<Cart> carts = this.cartService.getAllCart(principal.getName());		
		String outOfQuantity = null;
		for (Cart cart : carts) {
			if (cart.getQuantity() > cart.getProduct().getQuantity()) {
				outOfQuantity ="Xin lỗi! " + "<u>" + cart.getProduct().getName() +"</u>" + " vượt quá số lượng kho (" + cart.getProduct().getQuantity() + " còn lại)";
				redirectAttributes.addFlashAttribute("outOfQuantity", outOfQuantity);
				return "redirect:/cart";
			}
		}		
		double subtotal1 = 0;
		for (Cart cart : carts) {
			subtotal1 = subtotal1 + cart.getQuantity() * cart.getCost().floatValue();
		}
		BigDecimal subtotal = BigDecimal.valueOf(subtotal1);
		
		model.addAttribute("subtotal", subtotal);		
		
		model.addAttribute("carts", carts);
		this.commonService.getCommonObj(model);
		return "user/checkout";
	}
	
	@PostMapping("/create-payment")
	public String create(HttpServletRequest req, HttpServletResponse resp, Principal principal) throws ServletException, IOException {
		
	
		
		List<Cart> carts = this.cartService.getAllCart(principal.getName());
		User user = this.userService.getUser(principal.getName());
		List<Product> products = new ArrayList<>();
		double price = 0.00;
		for (Cart cart : carts) {
			products.add(cart.getProduct());
			if (cart.getProduct().getIsDiscount()) {
				price += cart.getProduct().getCostDiscount().doubleValue()*cart.getQuantity();
			} else {
				price += cart.getProduct().getCost().doubleValue()*cart.getQuantity();
			}
		}
		Order order = new Order();
		order.setUsername(principal.getName());
		order.setStatus(this.statusRepository.findByDeliveryStatus(com.example.constant.Status.CHOXACNHAN));
		order.setPrice(BigDecimal.valueOf(price));
		order.setPaymentMethod("ONLINE");
		order.setCheckRate(false);
		orderRepository.save(order);
		for (Product product : products) {
			OrderInfo orderInfo = new OrderInfo();
			OrderInfoID orderInfoID = new OrderInfoID();
			orderInfoID.setIdOrder(order.getIdOrder1());
			orderInfoID.setIdProduct(product.getIdProduct());
			orderInfo.setId(orderInfoID);
			for (Cart cart : carts) {
				if (cart.getProduct().equals(product)) {
					orderInfo.setPrice(cart.getCost());
					orderInfo.setQuantity(cart.getQuantity());
				}
			}
			orderInfoRepository.save(orderInfo);
		}
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));
		user.setName(req.getParameter("name"));
		user.setPhone(req.getParameter("phone"));
		userRepository.save(user);
		
		String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_OrderInfo = "thanh toan don hang";
        String orderType = "200000";
        String vnp_TxnRef = order.getIdOrder1().toString();
        String vnp_IpAddr = ConfigVNPay.getIpAddress(req);
        String vnp_TmnCode = ConfigVNPay.vnp_TmnCode;
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf((long) price*100));
        vnp_Params.put("vnp_CurrCode", "VND");
//        String bank_code = req.getParameter("bankcode");
//        if (bank_code != null && !bank_code.isEmpty()) {
//            vnp_Params.put("vnp_BankCode", "NCB");
//        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", orderType);

//        String locate = req.getParameter("language");
//        if (locate != null && !locate.isEmpty()) {
//            vnp_Params.put("vnp_Locale", locate);
//        } else {
            vnp_Params.put("vnp_Locale", "vn");
//        }
        vnp_Params.put("vnp_ReturnUrl", ConfigVNPay.vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        //Add Params of 2.0.1 Version
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        //Billing
        vnp_Params.put("vnp_Bill_Mobile", req.getParameter("txt_billing_mobile"));
        vnp_Params.put("vnp_Bill_Email", req.getParameter("txt_billing_email"));
//        String fullName = (req.getParameter("txt_billing_fullname")).trim();
//        if (fullName != null && !fullName.isEmpty()) {
//            int idx = fullName.indexOf(' ');
//            String firstName = fullName.substring(0, idx);
//            String lastName = fullName.substring(fullName.lastIndexOf(' ') + 1);
         

//        }
//        vnp_Params.put("vnp_Bill_Address", req.getParameter("txt_inv_addr1"));
//        vnp_Params.put("vnp_Bill_City", req.getParameter("txt_bill_city"));
//        vnp_Params.put("vnp_Bill_Country", req.getParameter("txt_bill_country"));
//        if (req.getParameter("txt_bill_state") != null && !req.getParameter("txt_bill_state").isEmpty()) {
//            vnp_Params.put("vnp_Bill_State", req.getParameter("txt_bill_state"));
//        }
        // Invoice
//        vnp_Params.put("vnp_Inv_Phone", req.getParameter("txt_inv_mobile"));
//        vnp_Params.put("vnp_Inv_Email", req.getParameter("txt_inv_email"));
//        vnp_Params.put("vnp_Inv_Customer", req.getParameter("txt_inv_customer"));
//        vnp_Params.put("vnp_Inv_Address", req.getParameter("txt_inv_addr1"));
//        vnp_Params.put("vnp_Inv_Company", req.getParameter("txt_inv_company"));
//        vnp_Params.put("vnp_Inv_Taxcode", req.getParameter("txt_inv_taxcode"));
//        vnp_Params.put("vnp_Inv_Type", req.getParameter("cbo_inv_type"));
        //Build data to hash and querystring
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = ConfigVNPay.hmacSHA512(ConfigVNPay.vnp_HashSecret, hashData.toString());
//        String vnp_SecureHash = Config.Sha256(Config.vnp_HashSecret + hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = ConfigVNPay.vnp_PayUrl + "?" + queryUrl;
        com.google.gson.JsonObject job = new JsonObject();
        job.addProperty("code", "00");
        job.addProperty("message", "success");
        job.addProperty("data", paymentUrl);
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(job));
        System.out.println(paymentUrl);
        return "redirect:"+paymentUrl;
	}
	
	@GetMapping("/payment-response")
	public String success(Principal principal,HttpServletRequest request, HttpServletResponse response, Model model	
			,@RequestParam(value = "vnp_Amount", required = false) String amount
			,@RequestParam(value = "vnp_BankCode", required = false) String vnp_BankCode
			,@RequestParam(value = "vnp_CardType", required = false) String vnp_CardType
			,@RequestParam(value = "vnp_OrderInfo", required = false) String vnp_OrderInfo
			,@RequestParam(value = "vnp_PayDate", required = false) String vnp_PayDate			
			,@RequestParam(value = "vnp_TransactionStatus", required = false) String vnp_TransactionStatus
			,@RequestParam(value = "vnp_TxnRef", required = false) String vnp_TxnRef
			) {
			 if (vnp_TransactionStatus.equals("02")) {
				 orderRepository.deleteById(Long.parseLong(vnp_TxnRef));
				 List<OrderInfo> orderInfos = this.orderInfoRepository.findByIdOrder(Long.parseLong(vnp_TxnRef));
				 orderInfoRepository.deleteAll(orderInfos);
				 model.addAttribute("cancel", true);
				return "user/payment-response";
			}
		    try
		    {
				            
			/*  IPN URL: Record payment results from VNPAY
			Implementation steps:
			Check checksum
			Find transactions (vnp_TxnRef) in the database (checkOrderId)
			Check the payment status of transactions before updating (checkOrderStatus)
			Check the amount (vnp_Amount) of transactions before updating (checkAmount)
			Update results to Database
			Return recorded results to VNPAY
			*/
					
		        // ex:  	PaymnentStatus = 0; pending 
		        //              PaymnentStatus = 1; success 
		        //              PaymnentStatus = 2; Faile 
		        
		        //Begin process return from VNPAY	
		        Map fields = new HashMap();
		        for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
		            String fieldName = (String) params.nextElement();
		            String fieldValue = request.getParameter(fieldName);
		            if ((fieldValue != null) && (fieldValue.length() > 0)) 
		            {
		                fields.put(fieldName, fieldValue);
		            }
		        }
		        System.out.println(fields);
		        
		        String vnp_SecureHash = request.getParameter("vnp_SecureHash");
		        if (fields.containsKey("vnp_SecureHashType")) 
		        {
		            fields.remove("vnp_SecureHashType");
		        }
		        if (fields.containsKey("vnp_SecureHash")) 
		        {
		            fields.remove("vnp_SecureHash");
		        }	
		        
		        PaymentInfo paymentInfo = new PaymentInfo();
		        paymentInfo.setAmount(BigDecimal.valueOf(Double.valueOf(amount)/100));
		        paymentInfo.setBankCode(vnp_BankCode);
		        paymentInfo.setCardType(vnp_CardType);
		        paymentInfo.setIdPaymentInfo(Long.parseLong(vnp_TxnRef));
		        paymentInfo.setOrderInfo(vnp_OrderInfo);
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		        LocalDateTime dateTime = LocalDateTime.parse(vnp_PayDate, formatter);
		        paymentInfo.setPayDate(dateTime);
		        paymentInffoRepository.save(paymentInfo);
		        		        
		        Order order =  orderRepository.findById(Long.parseLong(vnp_TxnRef)).get();
				order.setPaymentInfo(paymentInfo);
				orderRepository.save(order);
				List<Cart> carts = cartRepository.findByUsername(principal.getName());
				cartRepository.deleteAll(carts);

									        
		        Float cost = Float.parseFloat(amount);
		        model.addAttribute("success", true);
		        model.addAttribute("amount", cost/100);
		        model.addAttribute("vnp_BankCode", vnp_BankCode);
		        model.addAttribute("vnp_CardType", vnp_CardType);
		        model.addAttribute("vnp_OrderInfo", vnp_OrderInfo);
		        model.addAttribute("vnp_PayDate", LocalDateTime.parse(vnp_PayDate, formatter));
		        model.addAttribute("vnp_TransactionStatus","Giao dịch thành công");
		        model.addAttribute("vnp_TxnRef", vnp_TxnRef);
				// Check checksum
		        String signValue = ConfigVNPay.hashAllFields(fields);
		        System.out.println(signValue);
		        
		        if (signValue.equals(vnp_SecureHash)) 
		        {

		            boolean checkOrderId = true; // vnp_TxnRef exists in your database
		            boolean checkAmount = true; // vnp_Amount is valid (Check vnp_Amount VNPAY returns compared to the amount of the code (vnp_TxnRef) in the Your database).
		            boolean checkOrderStatus = true; // PaymnentStatus = 0 (pending)
					
					
		            if(checkOrderId)
		            {
		                if(checkAmount)
		                {
		                    if (checkOrderStatus)
		                    {
		                        if ("00".equals(request.getParameter("vnp_ResponseCode")))
		                        {
		                            
		                            //Here Code update PaymnentStatus = 1 into your Database
		                        }
		                        else
		                        {
		                            
		                            // Here Code update PaymnentStatus = 2 into your Database
		                        }
		                        System.out.print ("{\"RspCode\":\"00\",\"Message\":\"Confirm Success\"}");
		                    }
		                    else
		                    {
		                        
		                    	System.out.print("{\"RspCode\":\"02\",\"Message\":\"Order already confirmed\"}");
		                    }
		                }
		                else
		                {
		                	System.out.print("{\"RspCode\":\"04\",\"Message\":\"Invalid Amount\"}"); 
		                }
		            }
		            else
		            {
		            	System.out.print("{\"RspCode\":\"01\",\"Message\":\"Order not Found\"}");
		            }
		        } 
		        else 
		        {
		        	System.out.print("{\"RspCode\":\"97\",\"Message\":\"Invalid Checksum\"}");
		        }
		    }
		    catch(Exception e)
		    {
		    	System.out.print("{\"RspCode\":\"99\",\"Message\":\"Unknow error\"}");
		    }
			return "user/payment-response";

	}
	
}
