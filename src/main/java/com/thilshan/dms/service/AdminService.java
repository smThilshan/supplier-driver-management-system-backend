package com.thilshan.dms.service;

import com.thilshan.dms.dto.admin.AdminRequestDto;
import com.thilshan.dms.dto.admin.AdminResponseDto;

import java.util.List;

public interface AdminService {

    AdminResponseDto createAdmin(AdminRequestDto dto);
    List<AdminResponseDto> getAllAdmins();
    AdminResponseDto getAdminById(Long id);
    void deleteAdmin(Long id);
}
