package com.thilshan.dms.controller;

import com.thilshan.dms.dto.auth.AuthRequestDto;
import com.thilshan.dms.dto.auth.AuthResponseDto;
import com.thilshan.dms.entity.Admin;
import com.thilshan.dms.repository.AdminRepository;
import com.thilshan.dms.security.JwtTokenProvider;
//import com.thilshan.dms.service.AuthService;
import com.thilshan.dms.service.AuthService;
import com.thilshan.dms.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto request) {

        AuthResponseDto response = authService.authenticateUser(request);
        return ResponseEntity.ok(response);
    }


}
