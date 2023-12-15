package com.sukri.users.management.controller;

import com.sukri.users.management.dto.User;
import com.sukri.users.management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUserDetails() {
        return userService.getAllUserDetails();
    }
}
