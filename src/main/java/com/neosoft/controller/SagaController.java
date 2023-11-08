package com.neosoft.controller;

import com.neosoft.model.Order;
import com.neosoft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SagaController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order){
      try{
          Order placeOrders = orderService.placeOrder(order);
          return ResponseEntity.ok().body(order);
      }catch(Exception e){
         // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Order placement failed due to payment failure.");
          e.printStackTrace();
      }
        return ResponseEntity.ok().body(order);
    }
}
