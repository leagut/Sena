package com.Sena_Market.security.controller.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username", "message", "status", "jwt" , "cargo" })
public record AuthResponse(
        String username,
        String message,
        String jwt,
        Boolean status ,
        String cargo

) {
}