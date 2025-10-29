package com.thilshan.dms.dto.driver;

import com.thilshan.dms.emus.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DriverResponseDto {
    private String driverId; // external readable ID
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String nationality;
    private String qid;
    private LocalDate qidExpiryDate;
    private String licenseNo;
    private LocalDate licenseExpiryDate;
    private Status status;
    private Integer totalOrders;
    private LocalDate joinDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String vehicleNo; // optional vehicle reference
}
