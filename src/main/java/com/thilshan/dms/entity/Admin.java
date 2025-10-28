package com.thilshan.dms.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;
    private String role;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // One admin can send many notifications
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Notification> notifications;
}
