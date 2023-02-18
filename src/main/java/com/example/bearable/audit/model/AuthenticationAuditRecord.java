package com.example.bearable.audit.model;

import com.example.bearable.audit.model.AuditRecord;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;
@Entity
@Table(name = "AuditRecord")
public class AuthenticationAuditRecord implements AuditRecord {
    @Id
    @GeneratedValue
    private  UUID id;
    private  Instant creationTime;
    private String record;
    private  UUID userId;
    private UUID tokenId;

    private AuditRecordType auditRecordType;

    public AuthenticationAuditRecord(){
        this.creationTime = Instant.now();
        this.auditRecordType = AuditRecordType.AUTHENTICATION;
    }

    public AuthenticationAuditRecord(UUID userId, UUID tokenId) {
        this.userId = userId;
        this.tokenId = tokenId;
        this.creationTime = Instant.now();
        this.auditRecordType = AuditRecordType.AUTHENTICATION;
        this.record = String.format("User id %d created token %s at %t", this.userId, this.tokenId, this.creationTime);
    }

    public UUID getId(){
        return id;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getRecord(){
        return record;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId(){
        return userId;
    }

    public void setTokenId(UUID tokenId){
        this.tokenId = tokenId;
    }

    public UUID getTokenId(){
        return tokenId;
    }

    public void setAuditRecordType(AuditRecordType auditRecordType) {
        this.auditRecordType = auditRecordType;
    }

    public AuditRecordType getAuditRecordType(){
        return auditRecordType;
    }
    @Override
    public void createRecord(AuditRecord auditRecord){

    }

    @Override
    public AuditRecord getRecord(UUID id){
        return this;
    }
}
