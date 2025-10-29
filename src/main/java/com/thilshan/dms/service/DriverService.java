package com.thilshan.dms.service;

import com.thilshan.dms.dto.driver.DriverRequestDto;
import com.thilshan.dms.dto.driver.DriverResponseDto;
import java.util.List;

public interface DriverService {

    DriverResponseDto createDriver(DriverRequestDto dto);
    List<DriverResponseDto> getAllDrivers();
    DriverResponseDto getDriverById(Long id);
    void deleteDriver(Long id);

}
