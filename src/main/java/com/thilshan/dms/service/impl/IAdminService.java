package com.thilshan.dms.service.impl;

import com.thilshan.dms.dto.admin.AdminMapper;
import com.thilshan.dms.dto.admin.AdminRequestDto;
import com.thilshan.dms.dto.admin.AdminResponseDto;
import com.thilshan.dms.entity.Admin;
import com.thilshan.dms.repository.AdminRepository;
import com.thilshan.dms.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IAdminService implements AdminService {

    private final AdminRepository repository;
    private final AdminMapper mapper;

    @Override
    public AdminResponseDto createAdmin(AdminRequestDto dto) {
        Admin admin = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(admin));
    }

    @Override
    public List<AdminResponseDto> getAllAdmins() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public AdminResponseDto getAdminById(Long id) {
        Admin admin = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Admin Not Found"));
        return mapper.toResponse(admin);
    }

    @Override
    public void deleteAdmin(Long id) {
        repository.deleteById(id);
    }
}
