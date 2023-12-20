package com.sukri.users.management.service;

import com.sukri.users.management.entity.AddressDetails;
import com.sukri.users.management.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressDetailsService {

    private final AddressRepository addressRepository;

    public AddressDetails saveOrUpdateAddress(AddressDetails addressDetails) {
        return addressRepository.save(addressDetails);
    }
}
