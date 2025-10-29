package com.thilshan.dms.dto.order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDto {
    private Long orderId;
    private String orderNo;
    private Double amount;
    private LocalDateTime orderDate;
    private Long driverId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
