package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.UserRequest;
import com.ecommerce.userservice.dto.UserResponse;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserResponse register(UserRequest userRequest);

    public UserResponse getUserById(Long id);

    public List<UserResponse> getAllUsers();

    public void delete(Long id);


}
