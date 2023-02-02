package com.example.bearable.authentication.model;
import lombok.Data;

@Data
public class Account {
   private final String id;
   private final String email;
   private final String title;
   private final String firstName;
   private final String lastName;
   private final Role roleType;
   private final boolean isEnabled;

   public enum Role {
      ADMIN,USER
   }

}

