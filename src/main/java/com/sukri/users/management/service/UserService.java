package com.sukri.users.management.service;

import com.sukri.users.management.entity.AddressDetails;
import com.sukri.users.management.entity.UserDetails;
import com.sukri.users.management.enums.Common4XXExceptionEnum;
import com.sukri.users.management.exception.BaseException;
import com.sukri.users.management.exception.SearchFieldNotProvidedException;
import com.sukri.users.management.model.AddressModel;
import com.sukri.users.management.model.UserModel;
import com.sukri.users.management.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressDetailsService addressDetailsService;
    private final ModelMapper modelMapper;

    public List<UserModel> getAllUserDetails(String firstName, String lastName) {
        log.info("FirstName = {}, LastName = {}", firstName, lastName);
        if (isFirstNameAndLastNameProvided(firstName, lastName)) {
            return findByFirstNameAndLastName(firstName, lastName);
        }
        List<UserDetails> allUserDetails = getAllUserDetails();
        return allUserDetails.stream().map(t -> {
            return getUserModel(t);
        }).collect(Collectors.toList());

    }

    private UserModel getUserModel(UserDetails userDetails) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDetails, userModel);
        if (CollectionUtils.isNotEmpty(userDetails.getAddress())) {
            userModel.setAddress(userDetails.getAddress().stream().map(address -> {
                AddressModel addressModel = new AddressModel();
                BeanUtils.copyProperties(address, addressModel);
                return addressModel;
            }).collect(Collectors.toList()));
        }
        return userModel;
    }

    public UserDetails updateUserDetails(String empId, UserModel userModel) {
        Optional<UserDetails> existingUser = userRepository.findByEmpId(empId);
        return existingUser.map(userToBeSaved -> {
            modelMapper.map(userModel, userToBeSaved);
            userToBeSaved.setUpdatedDateTime(new Date());
            userRepository.save(userToBeSaved);
            return userToBeSaved;
        }).orElseThrow(() -> new BaseException(HttpStatus.BAD_REQUEST, Common4XXExceptionEnum.USER_NOT_FOUND.getError()));
    }

    /**
     * Below piece of commented out as not sure whether Address details needs to be updated along with user details.
     * <p>
     * if (CollectionUtils.isNotEmpty(userModel.getAddress())) {
     * List<AddressDetails> retAddressDetails = userModel.getAddress().stream().map(address -> {
     * address.setUserDetails(existingUser.get());
     * return addressDetailsService.saveOrUpdateAddress(address);
     * }).collect(Collectors.toList());
     * userDetails.setAddress(retAddressDetails);
     * }
     * return userDetails;
     */
    public List<UserDetails> getAllUserDetails() {
        return userRepository.findAll();
    }

    public List<UserModel> findByFirstNameAndLastName(String firstName, String lastName) {
        List<UserDetails> byFirstNameAndLastName = userRepository.findByFirstNameAndLastName(firstName, lastName);
        return byFirstNameAndLastName.stream().map(t -> {
            return getUserModel(t);
        }).collect(Collectors.toList());
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
