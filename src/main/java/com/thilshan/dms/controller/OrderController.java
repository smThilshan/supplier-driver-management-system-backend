package com.thilshan.dms.controller;

import com.thilshan.dms.dto.order.OrderRequestDto;
import com.thilshan.dms.dto.order.OrderResponseDto;
import com.thilshan.dms.repository.OrderRepository;
import com.thilshan.dms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    // Create a new order
//    @PostMapping
//    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto dto) {
//        return ResponseEntity.ok(service.createOrder(dto));
//    }

    // Get all orders
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
        return ResponseEntity.ok(service.getAllOrders());
    }

    // Get order by ID
    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }

//    // Update order
//    @PutMapping("/{id}")
//    public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable Long id,
//                                                        @RequestBody OrderRequestDto dto) {
//        return ResponseEntity.ok(orderService.updateOrder(id, dto));
//    }

    // Delete order
//    @DeleteMapping("/orders/{id}")
//    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
//        service.deleteOrder(id);
//        return ResponseEntity.noContent().build();
//    }

}
