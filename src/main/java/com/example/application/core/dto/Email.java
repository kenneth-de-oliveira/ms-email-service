package com.example.application.core.dto;

public record Email(
        String to,
        String subject,
        String text
) {
}