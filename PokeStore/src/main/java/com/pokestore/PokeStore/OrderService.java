package com.pokestore.PokeStore;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(String email, List<String> items, BigDecimal total) {
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setUserEmail(email);
        order.setItems(items);
        order.setTotalPrice(total);
        order.setCreatedAt(Instant.now());
        return orderRepository.save(order);
    }
}
