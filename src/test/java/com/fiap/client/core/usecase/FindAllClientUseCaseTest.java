package com.fiap.client.core.usecase;

import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FindAllClientUseCaseTest {

    private ClientGateway clientGateway;
    private FindAllClientsUseCase findAllClientsUseCase;

    @BeforeEach
    void setUp() {
        clientGateway = mock(ClientGateway.class);
        findAllClientsUseCase = new FindAllClientsUseCase(clientGateway);
    }

    @Test
    void testExecuteSuccessfullyFindsClients() {
        Client client1 = new Client("1", "John Doe", LocalDate.of(1990, 5, 20), "12345678900", List.of());
        Client client2 = new Client("2", "Jane Doe", LocalDate.of(1985, 2, 10), "98765432100", List.of());
        Set<Client> expectedClients = Set.of(client1, client2);

        when(clientGateway.findAll()).thenReturn(expectedClients);

        Set<Client> foundClients = findAllClientsUseCase.execute();

        assertNotNull(foundClients);
        assertEquals(2, foundClients.size());
        assertTrue(foundClients.contains(client1));
        assertTrue(foundClients.contains(client2));

        verify(clientGateway, times(1)).findAll();
    }

    @Test
    void testExecuteReturnsEmptySetWhenNoClientsExist() {
        when(clientGateway.findAll()).thenReturn(Set.of());

        Set<Client> foundClients = findAllClientsUseCase.execute();

        assertNotNull(foundClients);
        assertTrue(foundClients.isEmpty());

        verify(clientGateway, times(1)).findAll();
    }
}
