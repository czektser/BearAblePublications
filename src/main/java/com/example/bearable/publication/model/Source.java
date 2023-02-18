package com.example.bearable.publication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.net.URL;
import java.util.UUID;

@Entity
public class Source {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private URL url;
    private Boolean isBlacklisted;

    public UUID getId(){
        return id;
    }

    public void  setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public URL getUrl(){
        return url;
    }

    public void setIsBlacklisted(Boolean isBlacklisted){
        this.isBlacklisted = isBlacklisted;
    }

    public Boolean getIsBlacklisted(){
        return isBlacklisted;
    }
}
