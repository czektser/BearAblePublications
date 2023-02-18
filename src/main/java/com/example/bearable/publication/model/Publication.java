package com.example.bearable.publication.model;

import com.example.bearable.authentication.model.Account;
import com.example.bearable.grant.model.Grant;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Publication {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Boolean isBlacklisted;

    @ManyToMany
    @JoinTable(name = "AUTHOR_PUBLICATION",
        joinColumns = {@JoinColumn(name="PUBLICATION_ID", referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")})
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Account> authors = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "GRANT_PUBLICATION",
            joinColumns = {@JoinColumn(name="PUBLICATION_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "GRANT_ID", referencedColumnName = "ID")})
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Grant> grants = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "SOURCE_PUBLICATION",
            joinColumns = {@JoinColumn(name="PUBLICATION_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "SOURCE_ID", referencedColumnName = "ID")})
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Publication> sources = new HashSet<>();

    public UUID getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setIsBlacklisted(Boolean isBlacklisted) {
        this.isBlacklisted = isBlacklisted;
    }

    public Boolean getIsBlacklisted(){
        return isBlacklisted;
    }

}
