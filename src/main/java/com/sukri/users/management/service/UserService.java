package com.sukri.users.management.service;

import com.sukri.users.management.dto.User;
import com.sukri.users.management.entity.UserDetails;
import com.sukri.users.management.repository.AddressRepository;
import com.sukri.users.management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public List<User> getAllUserDetails() {
        List<UserDetails> usersEntity = userRepository.findAll();
        return usersEntity.stream().map(t -> {
            User user = User.builder().build();
            BeanUtils.copyProperties(t, user);
            return user;
        }).collect(Collectors.toList());
    }

    public User getUserDetails(String firstName, String lastName) {
        return User.builder().build();
    }

    public void updateUserDetails(User user) {

    }
}
