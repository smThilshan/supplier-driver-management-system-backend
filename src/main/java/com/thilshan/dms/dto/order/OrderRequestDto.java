package com.thilshan.dms.dto.order;

import lombok.Data;

@Data
public class OrderRequestDto {
    private String orderId;
    private Double amount;
    private String driverId;

}
