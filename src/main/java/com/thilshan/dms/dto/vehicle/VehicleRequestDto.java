package com.thilshan.dms.dto.vehicle;

import com.thilshan.dms.emus.VehicleStatus;
import com.thilshan.dms.emus.VehicleType;
import lombok.Data;

@Data
public class VehicleRequestDto {
    private String vehicleNo;
    private VehicleType type;
    private VehicleStatus status;
}
