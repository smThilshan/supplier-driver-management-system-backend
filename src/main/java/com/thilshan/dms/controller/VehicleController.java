package com.thilshan.dms.controller;

import com.thilshan.dms.dto.vehicle.VehicleRequestDto;
import com.thilshan.dms.dto.vehicle.VehicleResponseDto;
import com.thilshan.dms.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    // Create vehicle
    @PostMapping
    public ResponseEntity<VehicleResponseDto> createVehicle(@RequestBody VehicleRequestDto dto) {
        return ResponseEntity.ok(vehicleService.createVehicle(dto));
    }

    // Get all vehicles
    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    // Get vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    // Update vehicle
//    @PutMapping("/{id}")
//    public ResponseEntity<VehicleResponseDto> updateVehicle(@PathVariable Long id,
//                                                            @RequestBody VehicleRequestDto dto) {
//        return ResponseEntity.ok(vehicleService.updateVehicle(id, dto));
//    }

    // Delete vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

}
