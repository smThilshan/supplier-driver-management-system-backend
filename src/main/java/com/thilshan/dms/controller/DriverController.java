package com.thilshan.dms.controller;

import com.thilshan.dms.dto.driver.DriverRequestDto;
import com.thilshan.dms.dto.driver.DriverResponseDto;
import com.thilshan.dms.entity.Driver;
import com.thilshan.dms.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @PostMapping
    public ResponseEntity<DriverResponseDto> createDriver(@RequestBody DriverRequestDto dto) {
        return ResponseEntity.ok(driverService.createDriver(dto));
    }

    @GetMapping
    public ResponseEntity<List<DriverResponseDto>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverResponseDto> getDriverById(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.getDriverById(id));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver updatedDriver) {
//        return driverService.updateDriver(id, updatedDriver)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }

}
