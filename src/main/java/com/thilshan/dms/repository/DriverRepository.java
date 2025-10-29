package com.thilshan.dms.repository;

import com.thilshan.dms.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByDriverId(String driverId);
    Optional<Driver> findByEmail(String email);
    Optional<Driver> findByLicenseNo(String licenseNo);
    Optional<Driver> findByQid(String qid);

}
