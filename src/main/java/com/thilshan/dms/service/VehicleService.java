package com.thilshan.dms.service;

import com.thilshan.dms.dto.vehicle.VehicleRequestDto;
import com.thilshan.dms.dto.vehicle.VehicleResponseDto;

import java.util.List;

public interface VehicleService {
    VehicleResponseDto createVehicle(VehicleRequestDto dto);

    List<VehicleResponseDto> getAllVehicles();

    VehicleResponseDto getVehicleById(Long id);

    VehicleResponseDto updateVehicle(Long id, VehicleRequestDto dto);

    void deleteVehicle(Long id);

}
