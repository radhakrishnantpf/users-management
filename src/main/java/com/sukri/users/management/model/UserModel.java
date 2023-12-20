package com.sukri.users.management.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sukri.users.management.entity.AddressDetails;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserModel {
    private String title;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    private String gender;
    @JsonProperty("empid")
    private String empId;
    private List<AddressModel> address = new ArrayList<>();
}
