package com.example.bearable.audit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "AuditRecord")
public class SourceAuditRecord implements AuditRecord {
    @Id
    @GeneratedValue
    private  UUID id;
    private  Instant creationTime;
    private String record;
    private  UUID userId;
    private UUID tokenId;
    private Action action;

    private UUID sourceId;

    private AuditRecordType auditRecordType;
    enum Action {
        CREATE, BLACKLIST
    }
    public SourceAuditRecord(){
        this.creationTime = Instant.now();
        this.auditRecordType = AuditRecordType.AUTHENTICATION;
    }

    public SourceAuditRecord(UUID userId, UUID tokenId, UUID sourceId, Action action){
        this.userId = userId;
        this.tokenId = tokenId;
        this.creationTime = Instant.now();
        this.auditRecordType = AuditRecordType.SOURCE;
        this.action = action;
        this.sourceId = sourceId;
        this.record = String.format("User id %d performed action %s on source id %s at %t", this.userId, this.action, this.sourceId, this.creationTime);
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

    public AuditRecordType getAuditRecordType() {
        return auditRecordType;
    }

    public void setAction(Action action){
        this.action = action;
    }

    public Action getAction(){
        return action;
    }
    public void setSourceId(UUID sourceId) {
        this.sourceId = sourceId;
    }

    public UUID getSourceId(){
        return sourceId;
    }
    @Override
    public void createRecord(AuditRecord auditRecord){

    }

    @Override
    public AuditRecord getRecord(UUID id){
        return this;
    }
}
