package com.shaik.acknowledge.L2cache.listeners;

import com.shaik.acknowledge.L2cache.domain.AuditLog;
import com.shaik.acknowledge.L2cache.service.AuditLogService;
import com.shaik.acknowledge.L2cache.utils.SpringBeanUtil;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class AuditLogListener {

    @PrePersist
    public void prePersist(Object entity) {
        saveAuditLog(entity, "Save");
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        saveAuditLog(entity, "Update");
    }

    @PreRemove
    public void preRemove(Object entity) {
        saveAuditLog(entity, "Delete");
    }

    private void saveAuditLog(Object entity, String operation) {

        AuditLog auditLog = new AuditLog();
        auditLog.setEntityName(entity.getClass().getSimpleName());
        auditLog.setOperation(operation);

        AuditLogService auditLogService = SpringBeanUtil.getBean(AuditLogService.class);
        auditLogService.saveAuditLog(auditLog);

    }
}
