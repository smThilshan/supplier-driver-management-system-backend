package com.thilshan.dms.dto.admin;

import lombok.Data;

@Data
public class AdminRequestDto {
    private String email;
    private String username;
    private String password;
    private String fullName;
    private String role;
}
