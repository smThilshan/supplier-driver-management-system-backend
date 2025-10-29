package com.thilshan.dms.dto.vehicle;

import com.thilshan.dms.emus.VehicleStatus;
import com.thilshan.dms.emus.VehicleType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleResponseDto {
    private Long id;
    private String vehicleNo;
    private VehicleType type;
    private VehicleStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
