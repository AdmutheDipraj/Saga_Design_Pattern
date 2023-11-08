package com.neosoft.service.impl;

import com.neosoft.model.Order;
import com.neosoft.model.Payment;
import com.neosoft.repository.OrderRepository;
import com.neosoft.repository.PaymentRepository;
import com.neosoft.service.OrderService;
import com.neosoft.service.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentService paymentService;
    @Transactional
    @Override
    public Order placeOrder(Order order) {
        Order orders = orderRepository.save(order);

        Payment payment=new Payment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getAmount());
        paymentService.processPayment(payment);


        return orders;
    }
}
