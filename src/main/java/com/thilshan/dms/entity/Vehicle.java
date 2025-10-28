package com.thilshan.dms.entity;


import com.thilshan.dms.emus.VehicleStatus;
import com.thilshan.dms.emus.VehicleType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key, always unique

    @Column(name = "vehicle_no")
    private String vehicleNo; // Can be repeated if sold and reassigned

    @Enumerated(EnumType.STRING)
    private VehicleType type; // BIKE, CAR, VAN, TRUCK

    @Enumerated(EnumType.STRING)
    private VehicleStatus status; // ACTIVE, INACTIVE, SOLD

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Track current owner
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver currentDriver; // null if unassigned or sold
}
