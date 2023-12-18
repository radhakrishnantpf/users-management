package com.sukri.users.management.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "address_details")
public class AddressDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "postcode")
    private String postcode;
    @CreationTimestamp
    @JsonIgnore
    private Date createdDateTime;
    @CreationTimestamp
    @JsonIgnore
    private Date updatedDateTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserDetails userDetails;

    @Override
    public String toString() {
        return "AddressDetails{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", updatedDateTime=" + updatedDateTime +
                '}';
    }
}
