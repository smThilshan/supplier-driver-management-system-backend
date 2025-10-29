package com.thilshan.dms.repository;

import com.thilshan.dms.entity.RealtimeLocation;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface RealtimeLocationRepository extends JpaRepository<RealtimeLocation, Integer> {
}
