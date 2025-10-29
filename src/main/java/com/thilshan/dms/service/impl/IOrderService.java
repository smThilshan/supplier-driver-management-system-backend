package com.thilshan.dms.service.impl;

import com.thilshan.dms.dto.order.OrderMapper;
import com.thilshan.dms.dto.order.OrderRequestDto;
import com.thilshan.dms.dto.order.OrderResponseDto;
import com.thilshan.dms.entity.Driver;
import com.thilshan.dms.entity.Order;
import com.thilshan.dms.repository.DriverRepository;
import com.thilshan.dms.repository.OrderRepository;
import com.thilshan.dms.service.OrderService;
import jakarta.annotation.security.RunAs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IOrderService implements OrderService {
    private final OrderRepository orderRepository;
    private final DriverRepository driverRepository;
    private final OrderMapper mapper;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto dto) {
        Driver driver = driverRepository.findByDriverId((dto.getDriverId()))
                .orElseThrow(() -> new RuntimeException("Driver Not Found"));

        Order order = mapper.toEntity(dto, driver);
        return mapper.toResponse(orderRepository.save(order));
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Not Found"));
        return mapper.toResponse(order);
    }

    @Override
    public OrderResponseDto updateOrder(Long id, OrderRequestDto dto) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
