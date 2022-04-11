package com.example.service.iml;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.request.OrderRequest;
import com.example.entity.Cart;
import com.example.entity.Order;
import com.example.entity.OrderDetail;
import com.example.entity.OrderInfo;
import com.example.entity.OrderInfoID;
import com.example.entity.Product;
import com.example.entity.Status;
import com.example.entity.User;
import com.example.model.OrderDatatablesModel;
import com.example.model.OrderDetailDatatablesModel;
import com.example.model.OrderInfoModel;
import com.example.model.OrdersReponseModel;
import com.example.repository.CartRepository;
import com.example.repository.OrderInfoRepository;
import com.example.repository.OrderRepository;
import com.example.repository.OrderTestRepository;
import com.example.repository.ProductRespository;
import com.example.repository.StatusRepository;
import com.example.repository.UserRepository;
import com.example.service.CartService;
import com.example.service.OrderService;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderTestRepository orderTestRepository;

	private final CartService cartService;

	private final UserService userService;

	private final ProductRespository productRespository;

	private final StatusRepository statusRepository;

	private final CartRepository cartRepository;

	private final UserRepository userRepository;

	private final EntityManager entityManager;

	private final OrderRepository orderRepository;

	private final OrderInfoRepository orderInfoRepository;

	
	@Override
	public void createOrder(OrderRequest orderRequest, String username) {
		List<Cart> carts = this.cartService.getAllCart(username);
		User user = this.userService.getUser(username);
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
		order.setUsername(username);
		order.setStatus(this.statusRepository.findByDeliveryStatus(com.example.constant.Status.CHOXACNHAN));
		order.setPrice(BigDecimal.valueOf(price));
		order.setPaymentMethod("COD");
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
//		for (Cart cart : carts) {
//			Product product = cart.getProduct();
//			Order_Detail order_Detail = new Order_Detail();
//			order_Detail.setAddress(orderRequest.getAddress());
//			order_Detail.setEmail(orderRequest.getEmail());
//			order_Detail.setPhone(orderRequest.getPhone());
//			order_Detail.setFullname(orderRequest.getFullname());
//			order_Detail.setNote(orderRequest.getNote());
//			order_Detail.setQuantity(cart.getQuantity());
//			order_Detail.setProduct(cart.getProduct());
//			order_Detail.setStatus(this.statusRepository.findByDeliveryStatus(com.example.constant.Status.CHOXACNHAN));
//			order_Detail.setUsername(orderRequest.getUsername());
//			order_Detail.setCost(BigDecimal.valueOf(cart.getQuantity() * cart.getCost().floatValue()));
//			order_Detail.setCheckRate(false);
//			orderRepository.save(order_Detail);
//			product.setQuantity(product.getQuantity() - cart.getQuantity());
//			productRespository.save(product);
//			cartRepository.delete(cart);
//		}
		user.setAddress(orderRequest.getAddress());
		user.setEmail(orderRequest.getEmail());
		user.setName(orderRequest.getFullname());
		user.setPhone(orderRequest.getPhone());
		userRepository.save(user);
		cartRepository.deleteAll(carts);
	}

	@Override
	public List<Order> getOrderByUsername(String username) {
		// TODO Auto-generated method stub
		return this.orderRepository.findByUsername(Sort.by(Sort.Direction.DESC, "createAt"), username);
	}

	@Override
	public OrderDetailDatatablesModel getOrderDetailDatatablesModel() {
		return OrderDetailDatatablesModel.converter(this.orderTestRepository.findAll());
	}

	@Override
	public void changeStatusOrder(OrderRequest orderRequest) {
		Order order = this.orderRepository.getById(orderRequest.getIdOrder());
			Status status = this.statusRepository.getById(orderRequest.getIdStatus());
			order.setStatus(status);
		
		orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		this.orderTestRepository.deleteById(id);
	}

	@Override
	public OrderDatatablesModel getOrderDatatablesModel() {
		return OrderDatatablesModel.converter(this.orderRepository.findAll());
	}

	@Override
	public List<OrdersReponseModel> ordersReponseModels(String username) {
		List<Order> orders = this.orderRepository.findByUsername(Sort.by(Sort.Direction.DESC, "createAt"), username);
		List<OrdersReponseModel> ordersReponseModels = new ArrayList<>();
		
		for (int i = 0; i < orders.size(); i++) {
			List<OrderInfo> orderInfo = this.orderInfoRepository.findByIdOrder(orders.get(i).getIdOrder1());
			OrdersReponseModel ordersReponseModel = new OrdersReponseModel();
			List<OrderInfoModel> orderInfoModels = new ArrayList();
			for (int j = 0; j < orderInfo.size(); j++) {
				OrderInfoModel orderInfoModel = new OrderInfoModel();
				orderInfoModel.setOrderInfo(orderInfo.get(j));
				orderInfoModel.setProduct(this.productRespository.getById(orderInfo.get(j).getId().getIdProduct()));
				
				orderInfoModels.add(orderInfoModel);
			}
			ordersReponseModel.setIdOrder(orders.get(i).getIdOrder1());
			ordersReponseModel.setOrderInfoModels(orderInfoModels);
			ordersReponseModel.setPrice(orders.get(i).getPrice());
			ordersReponseModel.setStatus(orders.get(i).getStatus().getDeliveryStatus());
			ordersReponseModel.setCheckRate(orders.get(i).getCheckRate());
			ordersReponseModels.add(ordersReponseModel);
		}		
		return ordersReponseModels;
	}

}
