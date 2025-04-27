package com.fiap.client.infrastructure.repository;

import com.fiap.client.infrastructure.repository.model.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<ClientModel, String> {
    Optional<ClientModel> findByDocument(String document);

    void deleteByDocument(String document);
}

