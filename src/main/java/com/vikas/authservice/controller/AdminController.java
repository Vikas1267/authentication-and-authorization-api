package com.vikas.authservice.controller;

import com.vikas.authservice.dto.ApiResponse;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/dashboard")
    public ApiResponse<String> adminDashboard(Authentication authentication) {
        return new ApiResponse<>(
                true,
                "Admin dashboard accessed",
                authentication.getName()
        );
    }
}
