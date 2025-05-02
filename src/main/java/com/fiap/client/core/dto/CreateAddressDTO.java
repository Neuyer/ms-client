package com.fiap.client.core.dto;

public record CreateAddressDTO(
        String nickName,
        String street,
        String city,
        String state,
        String zipCode,
        Integer number
) {
}
