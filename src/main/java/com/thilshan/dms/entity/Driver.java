package com.thilshan.dms.entity;

import jakarta.persistence.*;
import jakarta.transaction.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "drivers",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"driver_id"}),
                @UniqueConstraint(columnNames = {"qid"}),
                @UniqueConstraint(columnNames = {"license_no"})
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Internal DB PK

    @Column(name = "driver_id", unique = true)
    private String driverId; // External readable ID

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String phoneNo;
    private String email;
    private String nationality;

    @Column(unique = true, nullable = false)
    private String qid;
    
    private LocalDate qidExpiryDate;

    @Column(name = "license_no", unique = true, nullable = false)
    private String licenseNo;

    private LocalDate licenseExpiryDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer totalOrders;
    private LocalDate joinDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Relationships
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<RealtimeLocation> realtimeLocations;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Notification> notifications;

}
