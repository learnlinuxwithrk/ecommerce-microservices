package com.ecommerce.userservice.service.impl;

import com.ecommerce.userservice.dto.User;
import com.ecommerce.userservice.dto.UserRequest;
import com.ecommerce.userservice.dto.UserResponse;
import com.ecommerce.userservice.repository.UserRepository;
import com.ecommerce.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse register(UserRequest userRequest) {
                  User user = User.builder()
                          .name(userRequest.getName())
                          .email(userRequest.getEmail())
                          .password(userRequest.getPassword())
                          .role(userRequest.getRole()).build();

       User newUser = userRepository.save(user);
       log.info("User Created Successfully  {}",newUser);
        return mapToUserResponse(newUser);
    }

    @Override
    public UserResponse getUserById(Long id) {
     User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found : "+id));
         log.info("user Fetched Successfully for Id : {}",id);
          return mapToUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        log.info("All user Fetched Successfully {}",users);
        return users.stream().map(this::mapToUserResponse).toList();
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found : "+id));
        log.info("User Successfully deleted for id : {}",id);
        userRepository.deleteById(id);
    }

    private UserResponse mapToUserResponse(User user) {


        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
