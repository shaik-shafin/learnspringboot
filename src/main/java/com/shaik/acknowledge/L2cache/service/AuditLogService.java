package com.shaik.acknowledge.L2cache.service;

import com.shaik.acknowledge.L2cache.domain.AuditLog;
import com.shaik.acknowledge.L2cache.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void saveAuditLog(AuditLog auditLog){
        auditLogRepository.save(auditLog);
    }
}
