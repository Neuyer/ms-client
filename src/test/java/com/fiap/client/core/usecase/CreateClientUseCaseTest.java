package com.fiap.client.core.usecase;

import com.fiap.client.core.dto.CreateClientDTO;
import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateClientUseCaseTest {

    private ClientGateway clientGateway;
    private CreateClientUseCase createClientUseCase;

    @BeforeEach
    void setUp() {
        clientGateway = mock(ClientGateway.class);
        createClientUseCase = new CreateClientUseCase(clientGateway);
    }

    @Test
    void testExecuteSuccessfullyCreatesClient() {
        String document = "12345678900";
        CreateClientDTO input = new CreateClientDTO("John Doe", LocalDate.of(1990, 5, 20), document);

        when(clientGateway.findByDocument(document)).thenReturn(Optional.empty());

        Client newClient = createClientUseCase.execute(input);

        assertNotNull(newClient);
        assertEquals("John Doe", newClient.getName());
        assertEquals(LocalDate.of(1990, 5, 20), newClient.getBirthDate());
        assertEquals(document, newClient.getDocument().getValue());

        verify(clientGateway, times(1)).save(any(Client.class));
    }

    @Test
    void testExecuteThrowsExceptionWhenClientAlreadyExists() {
        String document = "12345678900";
        CreateClientDTO input = new CreateClientDTO("John Doe", LocalDate.of(1990, 5, 20), document);
        Client existingClient = new Client(UUID.randomUUID().toString(), "Jane Doe", LocalDate.of(1985, 2, 10), document, List.of());

        when(clientGateway.findByDocument(document)).thenReturn(Optional.of(existingClient));

        Exception exception = assertThrows(IllegalStateException.class, () -> createClientUseCase.execute(input));
        assertEquals("Client with doc already exists", exception.getMessage());

        verify(clientGateway, never()).save(any());
    }
}
