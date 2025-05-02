package com.fiap.client.core.usecase;

import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteClientUseCaseTest {

    private ClientGateway clientGateway;
    private DeleteClientUseCase deleteClientUseCase;

    @BeforeEach
    void setUp() {
        clientGateway = mock(ClientGateway.class);
        deleteClientUseCase = new DeleteClientUseCase(clientGateway);
    }

    @Test
    void testExecuteSuccessfullyDeletesClient() {
        String document = "12345678900";
        Client existingClient = new Client("1", "John Doe", LocalDate.of(1990, 5, 20), document, List.of());

        when(clientGateway.findByDocument(document)).thenReturn(Optional.of(existingClient));

        assertDoesNotThrow(() -> deleteClientUseCase.execute(document));

        verify(clientGateway, times(1)).deleteByDocument(document);
    }

    @Test
    void testExecuteThrowsExceptionWhenClientNotFound() {
        String document = "12345678900";

        when(clientGateway.findByDocument(document)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalStateException.class, () -> deleteClientUseCase.execute(document));
        assertEquals("Client not found with doc: " + document, exception.getMessage());

        verify(clientGateway, never()).deleteByDocument(any());
    }
}
