package com.sukri.users.management.model;

import lombok.Data;

@Data
public class AddressModel {
    private String street;
    private String city;
    private String state;
    private Long postcode;
}
