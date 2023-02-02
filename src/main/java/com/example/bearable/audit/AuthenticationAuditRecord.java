package com.example.bearable.audit;

import lombok.Data;
import javax.persistence.*;

import java.time.Instant;
import java.util.UUID;
@Data
@Table(name = "Audit_Record")
public class AuthenticationAuditRecord implements AuditRecord {
    private final UUID id;
    private final  Instant creationTime;
    private final String record;
    private  final Long userId;
    private final UUID sessionId;

    public AuthenticationAuditRecord(Long userId, UUID sessionId) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.id = UUID.randomUUID();
        this.creationTime = Instant.now();
        this.record = String.format("User id %d created session %s at %t", this.userId, this.sessionId.toString(), this.creationTime);
    }

    @Override
    public void createRecord(AuditRecord auditRecord){

    }

    @Override
    public AuditRecord getRecord(UUID id){
        return this;
    }
}
