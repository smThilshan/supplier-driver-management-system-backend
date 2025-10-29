package com.thilshan.dms.dto.vehicle;

import com.thilshan.dms.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    // Convert Request DTO → Entity
    public Vehicle toEntity(VehicleRequestDto dto) {
        return Vehicle.builder()
                .vehicleNo(dto.getVehicleNo())
                .type(dto.getType())
                .status(dto.getStatus())
                .build();
    }

    // Convert Entity → Response DTO
    public VehicleResponseDto toResponse(Vehicle entity) {
        VehicleResponseDto dto = new VehicleResponseDto();
        dto.setId(entity.getId());
        dto.setVehicleNo(entity.getVehicleNo());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
