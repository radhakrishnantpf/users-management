package com.sukri.users.management.repository;

import com.sukri.users.management.entity.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressDetails, Long> {
}
