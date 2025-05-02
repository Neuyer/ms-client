package com.fiap.client.core.usecase;

import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RemoveAddressUseCase {

    private final ClientGateway clientGateway;

    public RemoveAddressUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(String id, String addressId) {
        log.info("Removing Client address with id: {}", addressId);

        var client = clientGateway.findById(id).orElseThrow(
                () -> {
                    log.error("Client with id {} doesn't exists", id);
                    return new IllegalStateException("Client with doc doesn't exists");
                }
        );


        client.getAddresses().removeIf(address -> address.getId().equals(addressId));

        clientGateway.save(client);
        log.info("Address for id {} created successfully", id);
        return client;
    }
}
