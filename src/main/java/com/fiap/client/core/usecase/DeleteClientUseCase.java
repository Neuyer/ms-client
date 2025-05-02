package com.fiap.client.core.usecase;

import com.fiap.client.core.gateway.ClientGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteClientUseCase {

    private final ClientGateway clientGateway;

    public DeleteClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public void execute(String document) {
        log.info("Deleting client with doc: {}", document);
        var clientOpt = clientGateway.findByDocument(document);

        if (clientOpt.isEmpty()) {
            log.error("Client not found with doc: {}", document);
            throw new IllegalStateException("Client not found with doc: " + document);
        }
        log.info("Client found with doc: {}", document);
        clientGateway.deleteByDocument(document);
    }
}
