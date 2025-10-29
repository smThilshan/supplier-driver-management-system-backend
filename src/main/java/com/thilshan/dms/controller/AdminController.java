package com.thilshan.dms.controller;

import com.thilshan.dms.dto.admin.AdminRequestDto;
import com.thilshan.dms.dto.admin.AdminResponseDto;
//import com.thilshan.dms.service.AdminService;
import com.thilshan.dms.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminResponseDto> createAdmin(@RequestBody AdminRequestDto dto) {
        return ResponseEntity.ok(adminService.createAdmin(dto));
    }

    @GetMapping
    public ResponseEntity<List<AdminResponseDto>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponseDto> getAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

}
