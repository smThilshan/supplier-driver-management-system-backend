package com.thilshan.dms.repository;

import com.thilshan.dms.entity.Vehicle;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Registered
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByVehicleNo(String vehicleNo);
}
