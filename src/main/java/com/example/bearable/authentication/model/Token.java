package com.example.bearable.authentication.model;

import lombok.Data;

import java.util.UUID;
import java.time.Instant;

@Data
public class Token { //TODO: create job to cleanup expired tokens
    private final UUID id;
    private final Instant creationTime;
    private final Instant expirationTime;
}
