package com.thilshan.dms.entity;

import com.thilshan.dms.emus.VehicleStatus;
import com.thilshan.dms.emus.VehicleType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vehicle_no")
    private String vehicleNo;
    @Enumerated(EnumType.STRING)
    private VehicleType type; // BIKE, CAR, VAN, TRUCK
    @Enumerated(EnumType.STRING)
    private VehicleStatus status; // ACTIVE, INACTIVE, SOLD

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
