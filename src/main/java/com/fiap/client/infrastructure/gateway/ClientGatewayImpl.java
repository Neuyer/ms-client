package com.fiap.client.infrastructure.gateway;

import com.fiap.client.core.entity.Client;
import com.fiap.client.core.gateway.ClientGateway;
import com.fiap.client.infrastructure.mapper.ClientMapper;
import com.fiap.client.infrastructure.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientGatewayImpl implements ClientGateway {

    private final ClientRepository clientRepository;

    public ClientGatewayImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findByDocument(String document) {
        return clientRepository.findByDocument(document)
                .map(ClientMapper::toEntity);
    }

    @Override
    public Set<Client> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public void save(Client client) {
        clientRepository.save(ClientMapper.toModel(client));
    }

    @Override
    public void deleteByDocument(String document) {
        clientRepository.deleteByDocument(document);
    }
}
