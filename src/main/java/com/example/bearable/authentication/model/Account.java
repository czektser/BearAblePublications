package com.example.bearable.authentication.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Account {
   @Id
   @GeneratedValue
   private  UUID id;
   private String email;
   private String title;
   private  String firstName;
   private String lastName;
   private Role roleType;
   private boolean isEnabled;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
   //annotation bellow is just for Jackson serialization in controller
   @JsonIdentityInfo(
           generator = ObjectIdGenerators.PropertyGenerator.class,
           property = "id")
   @JsonIdentityReference(alwaysAsId = true)
   private Set<Token> tokens = new HashSet();

   public enum Role {
      ADMIN,USER
   }

   public UUID getId(){
      return id;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getTitle(){
      return title;
   }


   public void setFirstName(String  firstName) {
      this.firstName = firstName;
   }

   public String getFirstName(){
      return firstName;
   }

   public void setLastName(String lastName){
      this.lastName = lastName;
   }

   public  String getLastName(){
      return lastName;
   }

   public void setEmail(String email){
      this.email = email;
   }

   public String getEmail(){
      return email;
   }

   public void setRoleType(Role roleType) {
      this.roleType = roleType;
   }

   public Role getRoleType(){
      return roleType;
   }

   public  void setEnabled(boolean isEnabled){
      this.isEnabled = isEnabled;
   }

   public boolean getEnabled(){
      return isEnabled;
   }


}

