package com.thilshan.dms.dto.admin;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AdminResponseDto {
    private Long id;
    private String fullName;
    private String username;
    private String email;
    private String role;
    private LocalDateTime createdAt;
}
