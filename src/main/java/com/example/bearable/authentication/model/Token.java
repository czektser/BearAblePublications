package com.example.bearable.authentication.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.persistence.ManyToOne;
import java.util.UUID;
import java.time.Instant;

@Entity
public class Token { //TODO: create job to cleanup expired tokens
    @Id
    @GeneratedValue
    private UUID id;
    private Instant creationTime;
    private Instant expirationTime;

    @ManyToOne
    //annotation bellow is just for Jackson serialization in controller
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Account account;

    public UUID getId(){
        return id;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Instant getCreationTime(){
        return creationTime;
    }

    public void setExpirationTime(Instant expirationTime) {
        this.expirationTime =  expirationTime;
    }

    public Instant getExpirationTime(){
        return expirationTime;
    }
}
