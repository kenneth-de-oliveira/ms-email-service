package com.example.application.usecase;

import com.example.application.core.dto.Email;
import com.example.application.core.port.in.EmailPortIn;
import com.example.application.core.port.out.EmailPortOut;

public class EmailUseCase implements EmailPortIn {

    private final EmailPortOut emailPortOut;

    public EmailUseCase(EmailPortOut emailPortOut) {
        this.emailPortOut = emailPortOut;
    }

    @Override
    public void send(Email email) {
        emailPortOut.send(email);
    }

}