package com.example.bearable.audit.model;

import java.util.UUID;

public interface AuditRecord {

    void createRecord(AuditRecord auditRecord);
    AuditRecord getRecord(UUID id);

    enum AuditRecordType {
        AUTHENTICATION,PUBLICATION,SOURCE,GRANT,EMAIL
    }
}
