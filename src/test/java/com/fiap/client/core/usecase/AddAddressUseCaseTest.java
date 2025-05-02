package com.fiap.client.core.usecase;

import com.fiap.client.core.dto.CreateAddressDTO;
import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddAddressUseCaseTest {

    private ClientGateway clientGateway;
    private AddAddressUseCase addAddressUseCase;


    @BeforeEach
    void setUp() {
        clientGateway = mock(ClientGateway.class);
        addAddressUseCase = new AddAddressUseCase(clientGateway);
    }

    @Test
    void testExecuteSuccessfullyAddsAddress() {
        String clientId = "1";
        CreateAddressDTO input = new CreateAddressDTO("Home", "123 Main St", "Springfield", "SP", "12345", 100);
        Client existingClient = new Client(clientId, "John Doe", LocalDate.of(1990, 5, 20), "12345678900", new ArrayList<>());

        when(clientGateway.findById(clientId)).thenReturn(Optional.of(existingClient));

        Client updatedClient = addAddressUseCase.execute(clientId, input);

        assertNotNull(updatedClient);
        assertEquals(1, updatedClient.getAddresses().size());
        assertEquals("Home", updatedClient.getAddresses().get(0).getNickName());

        verify(clientGateway, times(1)).save(existingClient);
    }

    @Test
    void testExecuteThrowsExceptionWhenClientNotFound() {
        String clientId = "1";
        CreateAddressDTO input = new CreateAddressDTO("Home", "123 Main St", "Springfield", "SP", "12345", 100);

        when(clientGateway.findById(clientId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalStateException.class, () -> addAddressUseCase.execute(clientId, input));
        assertEquals("Client with doc doesn't exists", exception.getMessage());

        verify(clientGateway, never()).save(any());
    }
}
