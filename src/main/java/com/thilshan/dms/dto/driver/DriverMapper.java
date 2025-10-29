package com.thilshan.dms.dto.driver;

import com.thilshan.dms.entity.Driver;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {
    public Driver toEntity(DriverRequestDto dto){
        return Driver.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .phoneNo(dto.getPhoneNo())
                .email(dto.getEmail())
                .nationality(dto.getNationality())
                .qid(dto.getQid())
                .qidExpiryDate(dto.getQidExpiryDate())
                .licenseNo(dto.getLicenseNo())
                .licenseExpiryDate(dto.getLicenseExpiryDate())
                .status(dto.getStatus())
                .joinDate(dto.getJoinDate())
                .build();
    }

    // Convert Entity → ResponseDTO
    public DriverResponseDto toResponse(Driver entity) {
        DriverResponseDto dto = new DriverResponseDto();
        dto.setDriverId(entity.getDriverId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhoneNo(entity.getPhoneNo());
        dto.setEmail(entity.getEmail());
        dto.setNationality(entity.getNationality());
        dto.setQid(entity.getQid());
        dto.setQidExpiryDate(entity.getQidExpiryDate());
        dto.setLicenseNo(entity.getLicenseNo());
        dto.setLicenseExpiryDate(entity.getLicenseExpiryDate());
        dto.setStatus(entity.getStatus());
        dto.setTotalOrders(entity.getTotalOrders());
        dto.setJoinDate(entity.getJoinDate());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
//        dto.setVehicleNo(entity.getVehicle() != null ? entity.getVehicle().getId() : null);
        return dto;
    }
}
