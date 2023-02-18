package com.example.bearable.authentication.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private Boolean isEnabled;

    @ManyToMany
    @JoinTable(name = "ACCOUNT_DEPARTMENT",
            joinColumns = {@JoinColumn(name="DEPARTMENT_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")})
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Account> accounts = new HashSet<>();

    public UUID getId(){
        return id;
    }

    public void setName(String name) {
        this.name  = name;
    }

    public String  getName(){
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String  getDescription(){
        return description;
    }

    public void setIsEnabled(boolean isEnabled){
        this.isEnabled = isEnabled;
    }

}
