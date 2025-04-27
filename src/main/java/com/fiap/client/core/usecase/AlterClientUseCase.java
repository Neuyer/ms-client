package com.fiap.client.core.usecase;

import com.fiap.client.core.dto.CreateClientDTO;
import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlterClientUseCase {
    private final ClientGateway clientGateway;

    public AlterClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(CreateClientDTO input) {
        log.info("Altering client with doc: {}", input.document());
        var clientOpt = clientGateway.findByDocument(input.document());
        if (clientOpt.isEmpty()) {
            log.error("Client not found with doc: {}", input.document());
            throw new IllegalStateException("Client not found with doc: " + input.document());
        }

        var client = new Client(
                clientOpt.get().get_id(),
                input.name(),
                input.birthDate(),
                input.document(),
                clientOpt.get().getAddresses()
        );

        clientGateway.save(client);
        log.info("Client altered with doc: {}", input.document());
        return client;
    }
}
