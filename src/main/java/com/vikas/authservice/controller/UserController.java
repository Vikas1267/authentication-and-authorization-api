package com.vikas.authservice.controller;

import com.vikas.authservice.dto.ApiResponse;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/profile")
    public ApiResponse<String> userProfile(Authentication authentication) {
        return new ApiResponse<>(
                true,
                "User profile fetched successfully",
                authentication.getName()
        );
    }
}
