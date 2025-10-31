package com.thilshan.dms.dto.admin;

import com.thilshan.dms.emus.Role;
import com.thilshan.dms.entity.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public Admin toEntity(AdminRequestDto dto) {
        return Admin.builder()
                .fullName(dto.getFullName())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(Role.valueOf(dto.getRole()))
                .build();
    }

    public AdminResponseDto toResponse(Admin entity) {
        return AdminResponseDto.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .role(String.valueOf(entity.getRole()))
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
