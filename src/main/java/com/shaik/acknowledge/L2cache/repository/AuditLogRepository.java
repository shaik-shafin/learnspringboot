package com.shaik.acknowledge.L2cache.repository;

import com.shaik.acknowledge.L2cache.domain.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {
}
