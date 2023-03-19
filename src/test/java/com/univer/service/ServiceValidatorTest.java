package com.univer.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.mockito.Mockito;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@SelectClasses(ServiceValidator.class)
public class ServiceValidatorTest {
    @Test
    @DisplayName("Test validatorEmail case")
    void testIsValidatorEmailGivesCorrectAnswers() throws IOException {
        assertFalse(new ServiceValidator().validatorEmail("testmail12@com"));
        assertTrue(new ServiceValidator().validatorEmail("testmail12@gmail.com"));
        assertFalse(new ServiceValidator().validatorEmail(null));
    }

    @Test
    @DisplayName("Test validatorEmailDuplicate case")
    void testIsValidatorEmailDuplicateGivesCorrectAnswers() {
        assertFalse(new ServiceValidator().validatorEmailDuplicate(null));
    }

    @Test
    @DisplayName("Test validatorPhone case")
    void testIsValidatorPhoneGivesCorrectAnswers() throws IOException {
        assertFalse(new ServiceValidator().validatorPhone("werr4556666"));
        assertTrue(new ServiceValidator().validatorPhone("0505673456"));
        assertFalse(new ServiceValidator().validatorPhone(null));
    }

    @Test
    @DisplayName("Test validatorIP case")
    void testIsValidatorIPGivesCorrectAnswers() {
        assertFalse(new ServiceValidator().validatorIP("345.2.2.2"));
        assertTrue(new ServiceValidator().validatorIP("8.8.8.8"));
        assertFalse(new ServiceValidator().validatorIP(null));
    }

    @Test
    @DisplayName("Test validatorTime error parameter case")
    void testIsValidatorTimeWithErrorParameter() throws IOException {
        ServiceValidator serviceValidator = Mockito.mock(ServiceValidator.class);

        given(serviceValidator.validatorTime("13.02.2022 12:30"))
                .willThrow(new RuntimeException("Проблема з датою"));


        try {
            serviceValidator.validatorTime("13.02.2022 12:30:23");
        } catch (Exception e) {
            assertEquals("Проблема з датою", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test validatorTime correct answer case")
    void testIsValidatorTimeGivesCorrectAnswers() throws IOException {
        ServiceValidator serviceValidatorToSpy = new ServiceValidator();
        ServiceValidator spyServiceValidator = Mockito.spy(serviceValidatorToSpy);
        LocalDateTime result = spyServiceValidator.validatorTime("13.02.2022 12:30");
        LocalDateTime localDateTime = LocalDateTime.parse("13.02.2022 12:30", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        assertEquals(localDateTime, result);
    }
}
