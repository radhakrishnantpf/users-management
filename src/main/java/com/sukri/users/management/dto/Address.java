package com.sukri.users.management.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String postcode;
}
