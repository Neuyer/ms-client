package com.fiap.client.core.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfDocumentTest {
    @Test
    void testValidCPF() {
        assertTrue(CpfDocument.isValidCPF("12345678901")); // 11-digit format
        assertTrue(CpfDocument.isValidCPF("123.456.789-01")); // Formatted CPF
    }

    @Test
    void testInvalidCPF() {
        assertFalse(CpfDocument.isValidCPF("123456")); // Too short
        assertFalse(CpfDocument.isValidCPF("abc.def.ghi-jk")); // Invalid characters
        assertFalse(CpfDocument.isValidCPF("123456789012")); // Too long
    }

    @Test
    void testCpfDocumentCreation() {
        CpfDocument cpf = new CpfDocument("12345678901");
        assertEquals("12345678901", cpf.getValue());

        CpfDocument formattedCpf = new CpfDocument("123.456.789-01");
        assertEquals("123.456.789-01", formattedCpf.getValue());
    }

    @Test
    void testCpfDocumentInvalidCreation() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new CpfDocument("invalid_cpf"));
        assertEquals("Invalid CPF", exception.getMessage());
    }
}
