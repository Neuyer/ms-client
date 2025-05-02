package com.fiap.client.infrastructure.repository.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressModel {
    String id;
    String nickName;
    String street;
    String city;
    String state;
    String zipCode;
    Integer number;
}
