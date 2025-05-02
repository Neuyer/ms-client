package com.fiap.client.infrastructure.gateway;

import com.fiap.client.core.entity.Client;
import com.fiap.client.infrastructure.mapper.ClientMapper;
import com.fiap.client.infrastructure.repository.ClientRepository;
import com.fiap.client.infrastructure.repository.model.ClientModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientGatewayImplTest {
    private ClientRepository clientRepository;
    private ClientGatewayImpl clientGateway;

    @BeforeEach
    void setUp() {
        clientRepository = mock(ClientRepository.class);
        clientGateway = new ClientGatewayImpl(clientRepository);
    }

    @Test
    void testFindByDocumentSuccessfullyReturnsClient() {
        String document = "12345678900";
        Client client = new Client("1", "John Doe", LocalDate.now(), document, List.of());

        when(clientRepository.findByDocument(document)).thenReturn(Optional.of(ClientMapper.toModel(client)));

        Optional<Client> foundClient = clientGateway.findByDocument(document);

        assertTrue(foundClient.isPresent());
        assertEquals(document, foundClient.get().getDocument().getValue());
        verify(clientRepository, times(1)).findByDocument(document);
    }

    @Test
    void testFindByDocumentReturnsEmptyWhenNotFound() {
        String document = "12345678900";

        when(clientRepository.findByDocument(document)).thenReturn(Optional.empty());

        Optional<Client> foundClient = clientGateway.findByDocument(document);

        assertFalse(foundClient.isPresent());
        verify(clientRepository, times(1)).findByDocument(document);
    }

    @Test
    void testFindByIdSuccessfullyReturnsClient() {
        String clientId = "1";
        Client client = new Client(clientId, "John Doe", LocalDate.now(), "12345678900", List.of());

        when(clientRepository.findById(clientId)).thenReturn(Optional.of(ClientMapper.toModel(client)));

        Optional<Client> foundClient = clientGateway.findById(clientId);

        assertTrue(foundClient.isPresent());
        assertEquals(clientId, foundClient.get().getId());
        verify(clientRepository, times(1)).findById(clientId);
    }

    @Test
    void testFindByIdReturnsEmptyWhenNotFound() {
        String clientId = "1";

        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        Optional<Client> foundClient = clientGateway.findById(clientId);

        assertFalse(foundClient.isPresent());
        verify(clientRepository, times(1)).findById(clientId);
    }

    @Test
    void testFindAllSuccessfullyReturnsClients() {
        Client client1 = new Client("1", "John Doe", LocalDate.now(), "12345678900", List.of());
        Client client2 = new Client("2", "Jane Doe", LocalDate.now(), "98765432100", List.of());
        List<ClientModel> clients = List.of(ClientMapper.toModel(client1), ClientMapper.toModel(client2));

        when(clientRepository.findAll()).thenReturn(clients);

        Set<Client> foundClients = clientGateway.findAll();

        assertNotNull(foundClients);
        assertEquals(2, foundClients.size());
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void testSaveSuccessfullyPersistsClient() {
        Client client = new Client("1", "John Doe", LocalDate.now(), "12345678900", List.of());

        clientGateway.save(client);

        verify(clientRepository, times(1)).save(ClientMapper.toModel(client));
    }

    @Test
    void testDeleteByDocumentSuccessfullyRemovesClient() {
        String document = "12345678900";

        clientGateway.deleteByDocument(document);

        verify(clientRepository, times(1)).deleteByDocument(document);
    }
}
