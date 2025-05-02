package com.fiap.client.core.usecase;

import com.fiap.client.core.entity.Address;
import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RemoveAddressUseCaseTest {

    private ClientGateway clientGateway;
    private RemoveAddressUseCase removeAddressUseCase;

    @BeforeEach
    void setUp() {
        clientGateway = mock(ClientGateway.class);
        removeAddressUseCase = new RemoveAddressUseCase(clientGateway);
    }

    @Test
    void testExecuteSuccessfullyRemovesAddress() {
        String clientId = "1";
        String addressId = "100";
        List<Address> addresses = new ArrayList<>();
        Address address = new Address(addressId, "Home", "123 Main St", "Springfield", "SP", "12345", 100);
        addresses.add(address);
        Client existingClient = new Client(clientId, "John Doe", LocalDate.of(1990, 5, 20), "12345678900", addresses);

        when(clientGateway.findById(clientId)).thenReturn(Optional.of(existingClient));

        Client updatedClient = removeAddressUseCase.execute(clientId, addressId);

        assertNotNull(updatedClient);
        assertTrue(updatedClient.getAddresses().isEmpty());

        verify(clientGateway, times(1)).save(existingClient);
    }

    @Test
    void testExecuteThrowsExceptionWhenClientNotFound() {
        String clientId = "1";
        String addressId = "100";

        when(clientGateway.findById(clientId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalStateException.class, () -> removeAddressUseCase.execute(clientId, addressId));
        assertEquals("Client with doc doesn't exists", exception.getMessage());

        verify(clientGateway, never()).save(any());
    }

    @Test
    void testExecuteDoesNothingWhenAddressNotFound() {
        String clientId = "1";
        Address address = new Address("200", "Home", "123 Main St", "Springfield", "SP", "12345", 100);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        Client existingClient = new Client(clientId, "John Doe", LocalDate.of(1990, 5, 20), "12345678900", addresses);

        when(clientGateway.findById(clientId)).thenReturn(Optional.of(existingClient));

        Client updatedClient = removeAddressUseCase.execute(clientId, "999"); // Non-existent address ID

        assertNotNull(updatedClient);
        assertEquals(1, updatedClient.getAddresses().size());

        verify(clientGateway, times(1)).save(existingClient);
    }
}
