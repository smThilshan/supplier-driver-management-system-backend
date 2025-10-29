package com.thilshan.dms.service.impl;

import com.thilshan.dms.dto.driver.DriverMapper;
import com.thilshan.dms.dto.driver.DriverRequestDto;
import com.thilshan.dms.dto.driver.DriverResponseDto;
import com.thilshan.dms.entity.Driver;
import com.thilshan.dms.repository.DriverRepository;
import com.thilshan.dms.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IDriverService implements DriverService {

    private final DriverRepository repository;
    private final DriverMapper mapper;

    @Override
    public DriverResponseDto createDriver(DriverRequestDto dto) {
        Driver driver = mapper.toEntity(dto);
        driver.setDriverId("DID-"+System.currentTimeMillis());
        return mapper.toResponse(repository.save(driver));
    }

    @Override
    public List<DriverResponseDto> getAllDrivers() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public DriverResponseDto getDriverById(Long id) {
        Driver driver = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Driver Not Found"));
        return mapper.toResponse(driver);
    }

    @Override
    public void deleteDriver(Long id) {
        Driver driver = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver Not Found"));
        repository.delete(driver);
    }
}
