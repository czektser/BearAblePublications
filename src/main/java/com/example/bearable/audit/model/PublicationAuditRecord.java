package com.example.bearable.audit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "AuditRecord")
public class PublicationAuditRecord implements AuditRecord {
    @Id
    @GeneratedValue
    private  UUID id;
    private  Instant creationTime;
    private String record;
    private  UUID userId;
    private UUID tokenId;
    private Action action;

    private UUID publicationID;

    private AuditRecordType auditRecordType;
    enum Action {
        CREATE, BLACKLIST
    }
    public PublicationAuditRecord(){
        this.creationTime = Instant.now();
        this.auditRecordType = AuditRecordType.AUTHENTICATION;
    }

    public PublicationAuditRecord(UUID userId, UUID tokenId, UUID publicationId, Action action){
        this.userId = userId;
        this.tokenId = tokenId;
        this.creationTime = Instant.now();
        this.auditRecordType = AuditRecordType.PUBLICATION;
        this.action = action;
        this.publicationID = publicationId;
        this.record = String.format("User id %d performed action %s on publication id %s at %t with token id %s", this.userId, this.action, this.publicationID, this.creationTime, this.tokenId);
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

    public void setPublicationID(UUID publicationID) {
        this.publicationID = publicationID;
    }

    public UUID getPublicationID(){
        return publicationID;
    }

    @Override
    public void createRecord(AuditRecord auditRecord){

    }

    @Override
    public AuditRecord getRecord(UUID id){
        return this;
    }
}
