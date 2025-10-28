package com.thilshan.dms.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", unique = true, nullable = false)
    private String orderId;
    private LocalDate orderDate;
    private String orderTime;
    private Integer orderCount;
    private String remarks;
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Relationship
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
