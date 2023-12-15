package com.sukri.users.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "user_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String title;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    private String gender;
    @JsonProperty("empid")
    private String empId;
    @JsonIgnore
    private Date createdDateTime;
    @JsonIgnore
    private Date updatedDateTime;
}
