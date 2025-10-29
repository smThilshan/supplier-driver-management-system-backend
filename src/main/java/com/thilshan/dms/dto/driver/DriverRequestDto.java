package com.thilshan.dms.dto.driver;

import com.thilshan.dms.emus.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DriverRequestDto {

    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String nationality;
    private String qid;
    private LocalDate qidExpiryDate;
    private String licenseNo;
    private LocalDate licenseExpiryDate;
    private Status status;
    private LocalDate joinDate;
    private String vehicleNo; // optional if
}
