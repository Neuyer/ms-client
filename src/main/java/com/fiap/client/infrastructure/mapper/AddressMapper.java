package com.fiap.client.infrastructure.mapper;

import com.fiap.client.core.entity.Address;
import com.fiap.client.infrastructure.repository.model.AddressModel;

public abstract class AddressMapper {
    private AddressMapper() {
    }

    public static Address toEntity(AddressModel addressModel) {
        return new Address(
                addressModel.getId(),
                addressModel.getNickName(),
                addressModel.getStreet(),
                addressModel.getCity(),
                addressModel.getState(),
                addressModel.getZipCode(),
                addressModel.getNumber());
    }

    public static AddressModel toModel(Address address) {
        return AddressModel.builder()
                .id(address.getId())
                .nickName(address.getNickName())
                .street(address.getStreet())
                .number(address.getNumber())
                .city(address.getCity())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .build();

    }
}
