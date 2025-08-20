package com.example.adapter.out;

import com.example.application.core.port.out.EmailPortOut;
import com.example.application.core.dto.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailAdapterOut implements EmailPortOut {

    private final JavaMailSender javaMailSender;

    public void sendEmail(Email email) {
        var message = this.buildSimpleMailMessage(email);
        javaMailSender.send(message);
    }

    private SimpleMailMessage buildSimpleMailMessage(Email email) {
        return new SimpleMailMessage() {{
            setTo(email.to());
            setSubject(email.subject());
            setText(email.text());
        }};
    }

}