package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.dto.ApiResponse;
import com.ecommerce.userservice.dto.User;
import com.ecommerce.userservice.dto.UserRequest;
import com.ecommerce.userservice.dto.UserResponse;
import com.ecommerce.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> register(@Valid @RequestBody UserRequest userRequest){

                         UserResponse userResponse = userService.register(userRequest);
                         return ResponseEntity.status(HttpStatus.CREATED)
                                 .body(ApiResponse.<UserResponse>builder()
                                         .success(true)
                                         .message("User Created Successfully")
                                         .data(userResponse).build());
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUser(){

        List<UserResponse> userResponses = userService.getAllUsers();

        return ResponseEntity.ok(ApiResponse.<List<UserResponse>>builder()
                .success(true)
                .message("All user List")
                .data(userResponses).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(Long id){
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(ApiResponse.<UserResponse>builder()
                .success(true)
                .message("User Found")
                .data(userResponse).build());

    }
@DeleteMapping("/{id}")
public ResponseEntity<ApiResponse> deleteUser(Long id){
        UserResponse userResponse = userService.getUserById(id);
         userService.delete(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.builder()
                 .success(true).message("User Deleted")
                 .data(userResponse).build());
}

}
