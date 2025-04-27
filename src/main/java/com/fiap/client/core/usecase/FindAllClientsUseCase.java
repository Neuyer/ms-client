package com.fiap.client.core.usecase;

import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class FindAllClientsUseCase {

    private final ClientGateway clientGateway;

    public FindAllClientsUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Set<Client> execute() {
        log.info("Finding all Clients");
        var clients = clientGateway.findAll();
        log.info("Found {} clients", clients.size());
        return clients;
    }
}
