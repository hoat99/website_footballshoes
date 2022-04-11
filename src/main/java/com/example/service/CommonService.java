package com.example.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.ui.Model;

import com.example.dto.request.MailRequest;
import com.example.dto.request.SubscribersRequest;
import com.example.entity.Order;

public interface CommonService {

	String removeAccent(String s);

	void getCommonObj(Model model);

	void sendMail(MailRequest mailRequest);

	void createSubscriber(SubscribersRequest subscribersRequest);

	List<BigDecimal> thongKeDoanhThu();

	List<BigDecimal> thongKeDoanhThuThangTruoc();

	List<Order> ordersReceived();

	List<Order> ordersNotReceived();

	List<Order> getOrderReceived(LocalDate date);

	List<Order> getOrderNotReceived(LocalDate date);
}
