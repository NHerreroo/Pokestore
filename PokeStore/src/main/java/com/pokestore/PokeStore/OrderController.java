package com.pokestore.PokeStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/crear")
    public ResponseEntity<Order> createOrder(@RequestBody Map<String, Object> orderData) {
        try {
            String userEmail = (String) orderData.get("user_email");
            List<String> items = (List<String>) orderData.get("items");
            BigDecimal totalPrice = new BigDecimal(orderData.get("total_price").toString());

            Order savedOrder = orderService.createOrder(userEmail, items, totalPrice);
            return ResponseEntity.ok(savedOrder);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}