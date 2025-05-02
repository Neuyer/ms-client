package com.fiap.client.core.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void testAddressCreation() {
        Address address = new Address("1", "Home", "123 Main St", "Springfield", "SP", "12345", 100);

        assertNotNull(address.getId());
        assertEquals("1", address.getId());
        assertEquals("Home", address.getNickName());
        assertEquals("123 Main St", address.getStreet());
        assertEquals("Springfield", address.getCity());
        assertEquals("SP", address.getState());
        assertEquals("12345", address.getZipCode());
        assertEquals(100, address.getNumber());
    }

    @Test
    void testAddressEquality() {
        Address address1 = new Address("1", "Home", "123 Main St", "Springfield", "SP", "12345", 100);
        Address address2 = new Address("1", "Office", "456 Elm St", "Springfield", "SP", "67890", 200);

        assertEquals(address1, address2); // Equality should be based on ID only
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    void testAddressInequality() {
        Address address1 = new Address("1", "Home", "123 Main St", "Springfield", "SP", "12345", 100);
        Address address2 = new Address("2", "Office", "456 Elm St", "Springfield", "SP", "67890", 200);

        assertNotEquals(address1, address2);
    }

    @Test
    void testAddressToString() {
        Address address = new Address("1", "Home", "123 Main St", "Springfield", "SP", "12345", 100);

        assertTrue(address.toString().contains("id='1'"));
        assertTrue(address.toString().contains("nickName='Home'"));
    }
}
