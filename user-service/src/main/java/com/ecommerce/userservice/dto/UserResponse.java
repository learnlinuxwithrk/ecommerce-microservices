package com.ecommerce.userservice.dto;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private String password;

    private String role;

}
