package com.thilshan.dms.service;

import com.thilshan.dms.dto.order.OrderRequestDto;
import com.thilshan.dms.dto.order.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto dto);

    List<OrderResponseDto> getAllOrders();

    OrderResponseDto getOrderById(Long id);

    OrderResponseDto updateOrder(Long id, OrderRequestDto dto);

    void deleteOrder(Long id);
}

