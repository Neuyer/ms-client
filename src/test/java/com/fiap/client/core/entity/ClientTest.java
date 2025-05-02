package com.fiap.client.core.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    @Test
    void testClientCreation() {
        LocalDate birthDate = LocalDate.of(1990, 5, 20);
        CpfDocument document = new CpfDocument("12345678900");
        List<Address> addresses = List.of(new Address("1", "Home", "123 Main St", "Springfield", "SP", "12345", 100));

        Client client = new Client("1", "John Doe", birthDate, "12345678900", addresses);

        assertNotNull(client.getId());
        assertEquals("1", client.getId());
        assertEquals("John Doe", client.getName());
        assertEquals(birthDate, client.getBirthDate());
        assertEquals(document.getValue(), client.getDocument().getValue());
        assertEquals(addresses, client.getAddresses());
    }

    @Test
    void testClientEquality() {
        LocalDate birthDate = LocalDate.of(1990, 5, 20);
        List<Address> addresses = List.of(new Address("1", "Home", "123 Main St", "Springfield", "SP", "12345", 100));

        Client client1 = new Client("1", "John Doe", birthDate, "12345678900", addresses);
        Client client2 = new Client("1", "Jane Doe", birthDate, "12345678900", addresses);

        assertEquals(client1, client2); // Equality should be based on ID only
        assertEquals(client1.hashCode(), client2.hashCode());
    }

    @Test
    void testClientInequality() {
        LocalDate birthDate = LocalDate.of(1990, 5, 20);
        List<Address> addresses = List.of(new Address("1", "Home", "123 Main St", "Springfield", "SP", "12345", 100));

        Client client1 = new Client("1", "John Doe", birthDate, "12345678900", addresses);
        Client client2 = new Client("2", "Jane Doe", birthDate, "98765432100", addresses);

        assertNotEquals(client1, client2);
    }

    @Test
    void testClientToString() {
        LocalDate birthDate = LocalDate.of(1990, 5, 20);
        List<Address> addresses = List.of(new Address("1", "Home", "123 Main St", "Springfield", "SP", "12345", 100));

        Client client = new Client("1", "John Doe", birthDate, "12345678900", addresses);

        assertTrue(client.toString().contains("id='1'"));
        assertTrue(client.toString().contains("name='John Doe'"));
    }
}
