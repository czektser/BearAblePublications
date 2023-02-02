package com.example.bearable.authentication.model;

import lombok.Data;

@Data
public class Department {
    private final Long id;
    private final String Name;
    private final Boolean isEnabled;
}
