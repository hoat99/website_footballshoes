package com.example.service.iml;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.dto.request.MailRequest;
import com.example.dto.request.SubscribersRequest;
import com.example.entity.Courtyard;
import com.example.entity.Order;
import com.example.entity.Strademark;
import com.example.entity.Subscribers;
import com.example.repository.OrderRepository;
import com.example.repository.SubscribersRepository;
import com.example.service.CartService;
import com.example.service.CommonService;
import com.example.service.CourtyardService;
import com.example.service.StrademarkService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService{

	private final StrademarkService strademarkService;
	
	private final CourtyardService courtyardService;
	
	private final JavaMailSender javaMailSender;
	
	private final CartService cartService;
	
	private final SubscribersRepository subscribersRepository;
	
	private final OrderRepository orderRepository;
	
	
	@Override
	public String removeAccent(String s) {
		s = s.toLowerCase();
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("đ", "d");
	}

	@Override
	public void getCommonObj(Model model) {
		List<Strademark> strademarks = this.strademarkService.getStrademarks();				
		model.addAttribute("strademarks", strademarks);
		List<Courtyard> courtyards = this.courtyardService.getAllCourtyards();
		model.addAttribute("courtyards", courtyards);
	}

	@Override
	public void sendMail(MailRequest request) {
		String mailTo = "nongvanhoat1999@gmail.com";
		
		SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mailTo);
        message.setSubject(request.getMailFrom() + " - " + request.getPhone());
        message.setText(request.getContent());

        // Send Message!
        this.javaMailSender.send(message);		
	}

	@Override
	public void createSubscriber(SubscribersRequest subscribersRequest) {
		Subscribers subscriber = new Subscribers();
		if (this.subscribersRepository.getSubscribersByEmail(subscribersRequest.getEmail()) == null) {
			subscriber.setEmail(subscribersRequest.getEmail());
			subscribersRepository.save(subscriber);
		}		
	}
	
	@Override
	public List<BigDecimal> thongKeDoanhThu() {
		LocalDate initial = LocalDate.now();
		LocalDate start = initial.withDayOfMonth(1);
		LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
		List<Order> orders = this.orderRepository.findByMonth();
		List<BigDecimal> doanhThu = new ArrayList<>();

		for (LocalDate j = start; j.compareTo(end) < 0; j = j.plusDays(5)) {
			BigDecimal total = new BigDecimal(0);
			for (Order order : orders) {
				if (order.getCreateAt().toLocalDate().compareTo(j) >= 0
						&& order.getCreateAt().toLocalDate().compareTo(j.plusDays(5)) <= 0) {
					total = total.add(order.getPrice());
				}
			}
			doanhThu.add(total);
		}
		return doanhThu;
	}

	@Override
	public List<BigDecimal> thongKeDoanhThuThangTruoc() {
		LocalDate initial = LocalDate.now().withDayOfMonth(1).minusMonths(1);
		LocalDate end = initial.withDayOfMonth(initial.lengthOfMonth());
		List<Order> orders = this.orderRepository.findByMonthBefore();
		List<BigDecimal> doanhThu = new ArrayList<>();

		for (LocalDate j = initial; j.compareTo(end) < 0; j = j.plusDays(5)) {
			BigDecimal total = new BigDecimal(0);
			for (Order order : orders) {
				if (order.getCreateAt().toLocalDate().compareTo(j) >= 0
						&& order.getCreateAt().toLocalDate().compareTo(j.plusDays(5)) <= 0) {
					total = total.add(order.getPrice());
				}
			}
			doanhThu.add(total);
		}
		return doanhThu;
	}

	@Override
	public List<Order> ordersReceived() {
		List<Order> orders = this.orderRepository.findByMonth();
		return orders;
	}

	@Override
	public List<Order> ordersNotReceived() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrderReceived(LocalDate date) {
		if (date.isEqual(LocalDate.now())) {
			List<Order> orders = this.orderRepository.findByMonth();
			List<Order> orders2 = new ArrayList<>();
			for (Order order : orders) {
				if (order.getReceivedAt() != null) {
					orders2.add(order);
				}
			}
			return orders2;
		}
		
		List<Order> orders = this.orderRepository.findByMonthBefore();
		List<Order> orders2 = new ArrayList<>();
		for (Order order : orders) {
			if (order.getReceivedAt() != null) {
				orders2.add(order);
			}
		}
		return orders2;
		
	}

	@Override
	public List<Order> getOrderNotReceived(LocalDate date) {
		if (date.isEqual(LocalDate.now())) {
			List<Order> orders = this.orderRepository.findByMonth();
			List<Order> orders2 = new ArrayList<>();
			for (Order order : orders) {
				if (order.getReceivedAt() == null) {
					orders2.add(order);
				}
			}
			return orders2;
		}
		
		List<Order> orders = this.orderRepository.findByMonthBefore();
		List<Order> orders2 = new ArrayList<>();
		for (Order order : orders) {
			if (order.getReceivedAt() == null) {
				orders2.add(order);
			}
		}
		return orders2;
	}

}
