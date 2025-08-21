package com.example.application.core.port.out;

import com.example.application.core.dto.Email;

public interface EmailPortOut {
    void send(Email email);
}
