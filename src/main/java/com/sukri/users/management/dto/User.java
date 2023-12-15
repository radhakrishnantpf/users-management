package com.sukri.users.management.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Generated;

import java.util.List;

@Data
@Builder
public class User {
    private Long id;
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String empId;
    private List<Address> addresses;
}
