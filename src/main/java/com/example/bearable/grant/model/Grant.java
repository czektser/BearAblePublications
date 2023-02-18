package com.example.bearable.grant.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Grant {
    @Id
    @GeneratedValue
    private UUID id;
    private Instant issueDate;
    private String name;
    private Double grantValue;
    private Boolean active;

    public UUID getId(){
        return id;
    }

    public void setIssueDate(Instant issueDate) {
        this.issueDate = issueDate;
    }

    public Instant getIssueDate(){
        return issueDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setGrantValue(Double grantValue) {
        this.grantValue = grantValue;
    }

    public Double getGrantValue(){
        return grantValue;
    }

    public void setActive(Boolean active){
        this.active = active;
    }

    public Boolean getActive(){
        return active;
    }

}
