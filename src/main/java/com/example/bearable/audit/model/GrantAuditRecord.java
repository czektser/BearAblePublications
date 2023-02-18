package com.example.bearable.audit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "AuditRecord")
public class GrantAuditRecord implements AuditRecord {
    @Id
    @GeneratedValue
    private  UUID id;
    private  Instant creationTime;
    private String record;
    private  UUID userId;
    private UUID tokenId;
    private Action action;

    private UUID grantId;

    private Double grantValue;

    private AuditRecordType auditRecordType;
    enum Action {
        CREATE, FUND, REVOKE
    }
    public GrantAuditRecord(){
        this.creationTime = Instant.now();
        this.auditRecordType = AuditRecordType.GRANT;
    }

    public GrantAuditRecord(UUID userId, UUID tokenId, UUID grantId, Action action){
        this.userId = userId;
        this.tokenId = tokenId;
        this.creationTime = Instant.now();
        this.auditRecordType = AuditRecordType.GRANT;
        this.action = action;
        this.grantId = grantId;
        this.record = String.format("User id %d performed action %s on grant id %s at %t with token id %s", this.userId, this.action, this.grantId, this.creationTime, this.tokenId);
    }

    public GrantAuditRecord(UUID userId, UUID tokenId, UUID grantId, Double grantValue){
        this.userId = userId;
        this.tokenId = tokenId;
        this.creationTime = Instant.now();
        this.auditRecordType = AuditRecordType.SOURCE;
        this.action = Action.FUND;
        this.grantId = grantId;

        this.grantValue = grantValue;
        this.record = String.format("User id %d funded grant id %s for amount %d at %t with token id %s", this.userId, this.grantId, this.grantValue, this.creationTime, this.tokenId);
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
    public void setGrantId(UUID grantId) {
        this.grantId = grantId;
    }

    public UUID getGrantId(){
        return grantId;
    }

    public void setGrantValue(Double grantValue) {
        this.grantValue = grantValue;
    }

    public Double getGrantValue(){
        return grantValue;
    }
    @Override
    public void createRecord(AuditRecord auditRecord){

    }

    @Override
    public AuditRecord getRecord(UUID id){
        return this;
    }
}
