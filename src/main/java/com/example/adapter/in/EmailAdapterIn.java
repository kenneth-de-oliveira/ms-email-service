package com.example.adapter.in;

import com.example.application.core.port.in.EmailPortIn;
import com.example.application.core.dto.Email;
import com.example.framework.errors.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/emails")
@RequiredArgsConstructor
public class EmailAdapterIn {

    private final EmailPortIn emailPortIn;

    @PostMapping
    public void sendEmail(@RequestBody Email email) {
        try {
            log.info("Sending mail to: {}, subject: {}, text: {}", email.to(), email.subject(), email.text());
            emailPortIn.send(email);
            log.info("Email sent successfully to: {}", email.to());
        } catch (Exception ex) {
            log.error("Error sending email: {}", ex.getMessage(), ex);
            throw new BusinessException(ex.getMessage(), ex);
        }
    }

}