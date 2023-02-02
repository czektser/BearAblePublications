package com.example.bearable.audit;

import java.util.UUID;

public interface AuditRecord {

    void createRecord(AuditRecord auditRecord);
    AuditRecord getRecord(UUID id);

    enum AuditRecordType {
        AUTHENTICATION
    }
}
