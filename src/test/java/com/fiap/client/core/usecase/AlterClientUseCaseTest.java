package com.fiap.client.core.usecase;

import com.fiap.client.core.dto.CreateClientDTO;
import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlterClientUseCaseTest {

    private ClientGateway clientGateway;
    private AlterClientUseCase alterClientUseCase;

    @BeforeEach
    void setUp() {
        clientGateway = mock(ClientGateway.class);
        alterClientUseCase = new AlterClientUseCase(clientGateway);
    }

    @Test
    void testExecuteSuccessfullyAltersClient() {
        String document = "12345678900";
        CreateClientDTO input = new CreateClientDTO("John Doe", LocalDate.of(1990, 5, 20), document);
        Client existingClient = new Client("1", "Jane Doe", LocalDate.of(1985, 2, 10), document, List.of());

        when(clientGateway.findByDocument(document)).thenReturn(Optional.of(existingClient));

        Client updatedClient = alterClientUseCase.execute(input);

        assertNotNull(updatedClient);
        assertEquals("John Doe", updatedClient.getName());
        assertEquals(LocalDate.of(1990, 5, 20), updatedClient.getBirthDate());
        assertEquals(document, updatedClient.getDocument().getValue());

        verify(clientGateway, times(1)).save(existingClient);
    }

    @Test
    void testExecuteThrowsExceptionWhenClientNotFound() {
        String document = "12345678900";
        CreateClientDTO input = new CreateClientDTO("John Doe", LocalDate.of(1990, 5, 20), document);

        when(clientGateway.findByDocument(document)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalStateException.class, () -> alterClientUseCase.execute(input));
        assertEquals("Client not found with doc: " + document, exception.getMessage());

        verify(clientGateway, never()).save(any());
    }
}
