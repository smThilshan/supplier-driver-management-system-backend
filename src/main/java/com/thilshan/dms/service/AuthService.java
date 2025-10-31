package com.thilshan.dms.service;

import com.thilshan.dms.dto.auth.AuthRequestDto;
import com.thilshan.dms.dto.auth.AuthResponseDto;
import com.thilshan.dms.entity.Admin;
import com.thilshan.dms.entity.Driver;
import com.thilshan.dms.repository.AdminRepository;
import com.thilshan.dms.repository.DriverRepository;
import com.thilshan.dms.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final AdminRepository adminRepository;
    private final DriverRepository driverRepository;

    public AuthResponseDto authenticateUser(  AuthRequestDto  request) {

        // 1️⃣ Authenticate credentials
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // 2️⃣ Check if Admin
        Admin admin = adminRepository.findByEmail(request.getEmail()).orElse(null);
        if (admin != null) {
            String token = jwtTokenProvider.generateToken(admin.getEmail(), admin.getRole().name());
            return new AuthResponseDto(token, admin.getRole().name());
        }

        // 3️⃣ Check if Driver
        Driver driver = driverRepository.findByEmail(request.getEmail()).orElse(null);
        if (driver != null) {
            String token = jwtTokenProvider.generateToken(driver.getEmail(), driver.getRole().name());
            return new AuthResponseDto(token, driver.getRole().name());
        }

        // 4️⃣ If neither found
        throw new RuntimeException("Invalid credentials");
    }
}