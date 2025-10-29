package com.thilshan.dms.dto;

import com.thilshan.dms.emus.VehicleStatus;
import com.thilshan.dms.emus.VehicleType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleDTO {
    private Long id;
    private String vehicleNo;
    private VehicleType type;
    private VehicleStatus status;

}
