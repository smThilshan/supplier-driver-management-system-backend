package com.thilshan.dms.service.impl;

import com.thilshan.dms.dto.vehicle.VehicleMapper;
import com.thilshan.dms.dto.vehicle.VehicleRequestDto;
import com.thilshan.dms.dto.vehicle.VehicleResponseDto;
import com.thilshan.dms.entity.Vehicle;
import com.thilshan.dms.repository.VehicleRepository;
import com.thilshan.dms.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IVehicleService implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper mapper;

    @Override
    public VehicleResponseDto createVehicle(VehicleRequestDto dto) {
        Vehicle vehicle = mapper.toEntity(dto);
        return mapper.toResponse(vehicleRepository.save(vehicle));
    }

    @Override
    public List<VehicleResponseDto> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public VehicleResponseDto getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle Not Found"));
        return mapper.toResponse(vehicle);
    }

    @Override
    public VehicleResponseDto updateVehicle(Long id, VehicleRequestDto dto) {
        return null;
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
