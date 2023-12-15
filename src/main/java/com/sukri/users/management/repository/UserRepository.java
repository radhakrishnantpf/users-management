package com.sukri.users.management.repository;


import com.sukri.users.management.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
    List<UserDetails> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<UserDetails> findByEmpId(String empId);
}
