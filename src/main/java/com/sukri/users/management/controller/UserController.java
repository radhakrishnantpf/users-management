package com.sukri.users.management.controller;

import com.sukri.users.management.dto.User;
import com.sukri.users.management.entity.UserDetails;
import com.sukri.users.management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/userdetails")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDetails> getAllUserDetails(@RequestParam(value = "firstname", required = false) String firstName,
                                               @RequestParam(value = "lastname", required = false) String lastName) {
        return userService.getAllUserDetails(firstName, lastName);
    }

    @PatchMapping("/userdetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDetails updateUserDetails(@PathVariable(value="id") String empId, @RequestBody UserDetails userDetails) {
        return userService.updateUserDetails(empId, userDetails);
    }
}
