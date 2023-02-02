package com.example.bearable.authentication.model;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class Session {
    private final UUID id;
    private final Instant creationTime;
    private final Instant expirationTime;
}
