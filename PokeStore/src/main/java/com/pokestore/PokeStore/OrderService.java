package com.pokestore.PokeStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(String user_email, List<String> items, BigDecimal totalPrice) {
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setCreated_at(new Date());
        order.setItems(items);
        order.setTotal_price(totalPrice);
        order.setUser_email(user_email);

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser_email(String user_email) {
        return orderRepository.findByUserEmailCustom(user_email);
    }
}