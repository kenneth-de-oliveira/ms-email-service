package com.example.application.core.port.in;

import com.example.application.core.dto.Email;

public interface EmailPortIn {
    void send(Email email);
}
