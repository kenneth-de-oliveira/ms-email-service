package com.example.application.usecase;

import com.example.application.core.dto.Email;
import com.example.application.core.port.in.EmailPortIn;
import com.example.application.core.port.out.EmailPortOut;

public class EmailUseCase implements EmailPortIn {

    private final EmailPortOut portOut;

    public EmailUseCase(EmailPortOut portOut) {
        this.portOut = portOut;
    }

    @Override
    public void sendEmail(Email email) {
        portOut.sendEmail(email);
    }

}