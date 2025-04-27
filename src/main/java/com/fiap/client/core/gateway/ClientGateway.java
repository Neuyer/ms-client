package com.fiap.client.core.gateway;

import com.fiap.client.core.entity.Client;

import java.util.Optional;
import java.util.Set;

public interface ClientGateway {
    Optional<Client> findByDocument(String document);

    Set<Client> findAll();

    void save(Client client);

    void deleteByDocument(String document);
}
