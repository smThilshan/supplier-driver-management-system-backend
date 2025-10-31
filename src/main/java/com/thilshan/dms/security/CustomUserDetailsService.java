package com.thilshan.dms.security;

import com.thilshan.dms.entity.Admin;
import com.thilshan.dms.entity.Driver;
import com.thilshan.dms.repository.AdminRepository;
import com.thilshan.dms.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AdminRepository adminRepository;
    private final DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email).orElse(null);
        if (admin != null) {
            return User.withUsername(admin.getEmail())
                    .password(admin.getPassword())
                    .roles("ADMIN")
                    .build();
        }

        Driver driver = driverRepository.findByEmail(email).orElse(null);
        if (driver != null) {
            return User.withUsername(driver.getEmail())
                    .password(driver.getPassword())
                    .roles("DRIVER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }

}
