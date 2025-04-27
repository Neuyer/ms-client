package com.fiap.client.core.usecase;

import com.fiap.client.core.dto.CreateClientDTO;
import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CreateClientUseCase {

    private final ClientGateway clientGateway;

    public CreateClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(CreateClientDTO input) {
        log.info("Creating Client with doc: {}", input.document());

        var product = clientGateway.findByDocument(input.document());
        if (product.isPresent()) {
            log.error("Client with doc {} already exists", input.document());
            throw new IllegalStateException("Client with doc already exists");
        }

        var client = new Client(input.name(), input.birthDate(), input.document(), List.of());
        clientGateway.save(client);
        log.info("Client with doc {} created successfully", input.document());
        return client;
    }
}
