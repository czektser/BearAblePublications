package com.example.bearable.audit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "AuditRecord")
public class EmailAuditRecord implements AuditRecord {
    @Id
    @GeneratedValue
    private  UUID id;
    private  Instant sentTime;
    private String record;
    private  UUID userId;
    private UUID tokenId;

    private AuditRecordType auditRecordType;

    public EmailAuditRecord(){
        this.sentTime = Instant.now();
        this.auditRecordType = AuditRecordType.EMAIL;
    }

    public EmailAuditRecord(UUID userId, UUID tokenId) {
        this.userId = userId;
        this.tokenId = tokenId;
        this.sentTime = Instant.now();
        this.auditRecordType = AuditRecordType.EMAIL;
        this.record = String.format("User id %d was emailed token id %s at %t", this.userId, this.tokenId, this.sentTime);
    }

    public UUID getId(){
        return id;
    }

    public void setSentTime(Instant sentTime) {
        this.sentTime = sentTime;
    }

    public Instant getCreationTime() {
        return sentTime;
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
