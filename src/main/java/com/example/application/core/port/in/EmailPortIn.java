package com.example.application.core.port.in;

import com.example.application.core.dto.Email;

public interface EmailPortIn {
    void sendEmail(Email email);
}
