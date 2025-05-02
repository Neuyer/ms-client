package com.fiap.client.infrastructure.controller;

import com.fiap.client.core.dto.CreateAddressDTO;
import com.fiap.client.core.dto.CreateClientDTO;
import com.fiap.client.core.entity.Client;
import com.fiap.client.core.usecase.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ClientControllerTest {
    private FindClientUseCase findClientUseCase;
    private FindAllClientsUseCase findAllClientsUseCase;
    private CreateClientUseCase createClientUseCase;
    private AddAddressUseCase addAddressUseCase;
    private RemoveAddressUseCase removeAddressUseCase;
    private AlterClientUseCase alterClientUseCase;
    private DeleteClientUseCase deleteClientUseCase;
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        findClientUseCase = mock(FindClientUseCase.class);
        findAllClientsUseCase = mock(FindAllClientsUseCase.class);
        createClientUseCase = mock(CreateClientUseCase.class);
        addAddressUseCase = mock(AddAddressUseCase.class);
        removeAddressUseCase = mock(RemoveAddressUseCase.class);
        alterClientUseCase = mock(AlterClientUseCase.class);
        deleteClientUseCase = mock(DeleteClientUseCase.class);

        clientController = new ClientController(findClientUseCase, findAllClientsUseCase, createClientUseCase,
                addAddressUseCase, removeAddressUseCase, alterClientUseCase, deleteClientUseCase);
    }

    @Test
    void testFindClientSuccessfully() {
        String cpf = "12345678900";
        Client client = new Client("1", "John Doe", LocalDate.of(1990, 5, 20), cpf, List.of());

        when(findClientUseCase.execute(cpf)).thenReturn(client);

        ResponseEntity<Client> response = clientController.findClient(cpf);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(client, response.getBody());
    }

    @Test
    void testFindAllClientsSuccessfully() {
        Client client1 = new Client("1", "John Doe", LocalDate.of(1990, 5, 20), "12345678900", List.of());
        Client client2 = new Client("2", "Jane Doe", LocalDate.of(1985, 2, 10), "98765432100", List.of());
        Set<Client> clients = Set.of(client1, client2);

        when(findAllClientsUseCase.execute()).thenReturn(clients);

        ResponseEntity<Set<Client>> response = clientController.findAllClients();

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testCreateClientSuccessfully() {
        CreateClientDTO input = new CreateClientDTO("John Doe", LocalDate.of(1990, 5, 20), "12345678900");
        Client client = new Client("1", "John Doe", LocalDate.of(1990, 5, 20), "12345678900", List.of());

        when(createClientUseCase.execute(input)).thenReturn(client);

        ResponseEntity<Client> response = clientController.createClient(input);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(client, response.getBody());
    }

    @Test
    void testDeleteClientSuccessfully() {
        String cpf = "12345678900";

        doNothing().when(deleteClientUseCase).execute(cpf);

        ResponseEntity<Void> response = clientController.deleteClient(cpf);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testCreateAddressSuccessfully() {
        String clientId = "1";
        CreateAddressDTO input = new CreateAddressDTO("Home", "123 Main St", "Springfield", "SP", "12345", 100);
        Client client = new Client(clientId, "John Doe", LocalDate.of(1990, 5, 20), "12345678900", List.of());

        when(addAddressUseCase.execute(clientId, input)).thenReturn(client);

        ResponseEntity<Client> response = clientController.createAddress(clientId, input);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testRemoveAddressSuccessfully() {
        String clientId = "1";
        String addressId = "100";
        Client client = new Client(clientId, "John Doe", LocalDate.of(1990, 5, 20), "12345678900", List.of());

        when(removeAddressUseCase.execute(clientId, addressId)).thenReturn(client);

        ResponseEntity<Client> response = clientController.createAddress(clientId, addressId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }
}
