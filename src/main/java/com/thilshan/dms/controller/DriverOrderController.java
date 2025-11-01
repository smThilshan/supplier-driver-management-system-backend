package com.thilshan.dms.controller;

import com.thilshan.dms.dto.order.OrderRequestDto;
import com.thilshan.dms.dto.order.OrderResponseDto;
import com.thilshan.dms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/driver/orders")
@RequiredArgsConstructor
public class DriverOrderController {
    private final OrderService orderService;

    // Driver adds their daily order summary (no order IDs, just count)
    @PostMapping
    public ResponseEntity<OrderResponseDto> addDailyOrders(
            @RequestBody OrderRequestDto dto,
            @RequestParam Long driverId) {
        return ResponseEntity.ok(orderService.addDailyOrders(driverId, dto));
    }

    // Driver views all their past orders
    @GetMapping("/{driverId}")
    public ResponseEntity<List<OrderResponseDto>> getOrdersByDriver(@PathVariable Long driverId) {
        return ResponseEntity.ok(Collections.singletonList(orderService.getOrdersByDriver(driverId)));
    }
}
