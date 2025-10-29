package com.thilshan.dms.entity;

import com.thilshan.dms.emus.NotificationStatus;
import com.thilshan.dms.emus.TargetType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message; // Mandatory field (cannot be null)

    @Enumerated(EnumType.STRING)
    @Column(name = "target_type", nullable = false)
    private TargetType targetType; // DRIVER or ADMIN

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationStatus status; // SENT or PENDING
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
