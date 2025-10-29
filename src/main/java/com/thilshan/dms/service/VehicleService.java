package com.thilshan.dms.service;

import com.thilshan.dms.entity.Driver;
import com.thilshan.dms.entity.Vehicle;
import com.thilshan.dms.repository.DriverRepository;
import com.thilshan.dms.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    public Vehicle createVehicle(Vehicle vehicle, Long driverId) {
        if (driverId != null) {
            Driver driver = driverRepository.findById(driverId)
                    .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + driverId));
            vehicle.setDriver(driver);
        }
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

//    public Optional<Vehicle> getVehicleByVehicleNo(Long id) {
//        return vehicleRepository.findById(id);
//    }
}
