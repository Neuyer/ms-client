package com.fiap.client.core.usecase;

import com.fiap.client.core.dto.CreateAddressDTO;
import com.fiap.client.core.entity.Address;
import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class AddAddressUseCase {

    private final ClientGateway clientGateway;

    public AddAddressUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(String id, CreateAddressDTO input) {
        log.info("Creating Client address with id: {}", id);

        var client = clientGateway.findById(id).orElseThrow(
                () -> {
                    log.error("Client with id {} doesn't exists", id);
                    return new IllegalStateException("Client with doc doesn't exists");
                }
        );

        var address = new Address(UUID.randomUUID().toString(), input.nickName(), input.street(), input.city(), input.state(), input.zipCode(), input.number());

        client.getAddresses().add(address);

        clientGateway.save(client);
        log.info("Address for id {} created successfully", id);
        return client;
    }
}
