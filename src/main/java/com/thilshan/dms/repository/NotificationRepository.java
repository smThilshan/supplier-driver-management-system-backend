package com.thilshan.dms.repository;

import com.thilshan.dms.entity.RealtimeLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<RealtimeLocation, Integer> {
}
