package com.example.application.usecase;

import com.example.application.core.dto.Email;
import com.example.application.core.port.out.EmailPortOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

class EmailUseCaseTest {

    private EmailUseCase emailUseCase;

    @Mock
    private EmailPortOut emailPortOut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        emailUseCase = new EmailUseCase(emailPortOut);
    }

    @Test
    void testSendEmailSuccess() {
        Email email = new Email("test@example.com", "Subject", "Body");
        Mockito.doNothing().when(emailPortOut).sendEmail(any(Email.class));
        assertDoesNotThrow(() -> emailUseCase.sendEmail(email));
    }

    @Test
    void testSendEmailFailure() {
        Email email = new Email("fail@example.com", "Subject", "Body");
        doThrow(RuntimeException.class).when(emailPortOut).sendEmail(any(Email.class));
        assertThrows(RuntimeException.class, () -> emailUseCase.sendEmail(email));
    }

}
