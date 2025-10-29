package com.thilshan.dms.dto.order;

import com.thilshan.dms.entity.Driver;
import com.thilshan.dms.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderMapper {

    // Convert DTO → Entity
    public Order toEntity(OrderRequestDto dto, Driver driver) {
        return Order.builder()
                .orderId(dto.getOrderId())            // From DTO
                .amount(dto.getAmount())              // From DTO
                .driver(driver)                       // Set Driver entity
                .orderDate(LocalDateTime.now())       // Auto-set current time
                .status("PENDING")                    // Default status, can change later
                .orderCount(1)                        // Default 1, can be updated
                .remarks(null)                        // Optional
                .build();
    }

    // Convert Entity → ResponseDTO
    public OrderResponseDto toResponse(Order entity) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderNo(entity.getOrderId());
        dto.setAmount(entity.getAmount());
        dto.setOrderDate(entity.getOrderDate());
        dto.setDriverId(entity.getDriver() != null ? entity.getDriver().getId() : null);
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
