package com.sukri.users.management.service;

import com.sukri.users.management.entity.UserDetails;
import com.sukri.users.management.enums.Common4XXExceptionEnum;
import com.sukri.users.management.exception.SearchFieldNotProvidedException;
import com.sukri.users.management.exception.UserNotFoundException;
import com.sukri.users.management.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserDetails> getAllUserDetails(String firstName, String lastName) {
        log.info("FirstName = {}, LastName = {}", firstName, lastName);
        if (isFirstNameAndLastNameProvided(firstName, lastName)) {
            List<UserDetails> byFirstNameAndLastName = findByFirstNameAndLastName(firstName, lastName);
            if(byFirstNameAndLastName.isEmpty()){
                throw new UserNotFoundException(Common4XXExceptionEnum.USER_NOT_FOUND.getError());
            }
        }
        return getAllUserDetails();
    }

    public UserDetails updateUserDetails(String empId, UserDetails userDetails) {
        Optional<UserDetails> existingUser = userRepository.findByEmpId(empId);

        if (existingUser.isEmpty()) {
            throw new UserNotFoundException(Common4XXExceptionEnum.USER_NOT_FOUND.getError());
        }

        UserDetails userToBeSaved = existingUser.get();
        modelMapper.map(userDetails, userToBeSaved);
        userToBeSaved.setUpdatedDateTime(new Date());
        userRepository.save(userToBeSaved);
        return userToBeSaved;

    }

    public List<UserDetails> getAllUserDetails() {
        return userRepository.findAll();
    }

    public List<UserDetails> findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    private boolean isFirstNameAndLastNameProvided(String firstName, String lastName) {
        if (StringUtils.isBlank(firstName) && StringUtils.isNotBlank(lastName)) {
            throw new SearchFieldNotProvidedException(
                    Common4XXExceptionEnum.FIRST_NAME_OR_LAST_NAME_NOT_PROVIDED
                            .getError("firstname"));
        }
        if (StringUtils.isNotBlank(firstName) && StringUtils.isBlank(lastName)) {
            throw new SearchFieldNotProvidedException(
                    Common4XXExceptionEnum.FIRST_NAME_OR_LAST_NAME_NOT_PROVIDED
                            .getError("lastname"));
        }
        return (StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName));
    }
}
