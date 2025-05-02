package com.fiap.client.core.usecase;

import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FindClientUseCase {
    private final ClientGateway clientGateway;

    public FindClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(String document) {
        log.info("Finding Client with doc: {}", document);
        var clienttOpt = clientGateway.findByDocument(document);

        if (clienttOpt.isEmpty()) {
            log.error("Client not found with doc: {}", document);
            throw new IllegalStateException("Client not found with doc: " + document);
        }

        log.info("Client found with doc: {}", document);
        return clienttOpt.get();
    }
}
