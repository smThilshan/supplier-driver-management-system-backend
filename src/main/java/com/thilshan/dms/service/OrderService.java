package com.thilshan.dms.service;

import com.thilshan.dms.dto.order.OrderRequestDto;
import com.thilshan.dms.dto.order.OrderResponseDto;

import java.util.List;

public interface OrderService {
    //this is not used i only allowed to driver to add order
    OrderResponseDto createOrder(OrderRequestDto dto);

    OrderResponseDto addDailyOrders(Long driverId,OrderRequestDto dto);

    List<OrderResponseDto> getAllOrders();

    OrderResponseDto getOrderById(Long id);

    OrderResponseDto getOrdersByDriver(Long driverId);





    OrderResponseDto updateOrder(Long id, OrderRequestDto dto);

    void deleteOrder(Long id);
}

