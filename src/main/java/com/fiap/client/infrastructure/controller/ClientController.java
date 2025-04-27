package com.fiap.client.infrastructure.controller;

import com.fiap.client.core.dto.CreateClientDTO;
import com.fiap.client.core.entity.Client;
import com.fiap.client.core.usecase.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final FindClientUseCase findClientUseCase;
    private final FindAllClientsUseCase findAllClientsUseCase;
    private final CreateClientUseCase createClientUseCase;
    private final AlterClientUseCase alterClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;

    public ClientController(FindClientUseCase findClientUseCase, FindAllClientsUseCase findAllClientsUseCase, CreateClientUseCase createClientUseCase, AlterClientUseCase alterClientUseCase, DeleteClientUseCase deleteClientUseCase) {
        this.findClientUseCase = findClientUseCase;
        this.findAllClientsUseCase = findAllClientsUseCase;
        this.createClientUseCase = createClientUseCase;
        this.alterClientUseCase = alterClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
    }

    @GetMapping("{cpf}")
    public ResponseEntity<Client> findClient(@PathVariable String cpf) {
        return ResponseEntity.ok(findClientUseCase.execute(cpf));
    }

    @GetMapping
    public ResponseEntity<Set<Client>> findAllClients() {
        return ResponseEntity.ok(findAllClientsUseCase.execute());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody CreateClientDTO createClientDTO) {
        return ResponseEntity.ok(createClientUseCase.execute(createClientDTO));
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody CreateClientDTO createClientDTO) {
        return ResponseEntity.ok(alterClientUseCase.execute(createClientDTO));
    }

    @DeleteMapping("{cpf}")
    public ResponseEntity<Void> deleteClient(@PathVariable String cpf) {
        deleteClientUseCase.execute(cpf);
        return ResponseEntity.ok()
                .build();
    }
}
