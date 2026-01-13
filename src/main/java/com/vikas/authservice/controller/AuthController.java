package com.vikas.authservice.controller;

import com.vikas.authservice.dto.LoginRequest;
import com.vikas.authservice.dto.LoginResponse;
import com.vikas.authservice.dto.RefreshRequest;
import com.vikas.authservice.entity.RefreshToken;
import com.vikas.authservice.entity.Role;
import com.vikas.authservice.entity.User;
import com.vikas.authservice.security.JwtUtil;
import com.vikas.authservice.service.RefreshTokenService;
import com.vikas.authservice.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final RefreshTokenService refreshTokenService;

    public AuthController(
            UserService userService,
            JwtUtil jwtUtil,
            RefreshTokenService refreshTokenService
    ) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.refreshTokenService = refreshTokenService;
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        User user = userService.validateUser(
                request.getUsername(),
                request.getPassword()
        );

        List<String> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .toList();

        String accessToken =
                jwtUtil.generateToken(user.getUsername(), roles);

        RefreshToken refreshToken =
                refreshTokenService.createRefreshToken(user);

        return new LoginResponse(
                accessToken,
                refreshToken.getToken()
        );
    }

    // ---------------- REFRESH ----------------
    @PostMapping("/refresh")
    public LoginResponse refresh(@RequestBody RefreshRequest request) {

        RefreshToken token =
                refreshTokenService.verifyExpiration(
                        refreshTokenService.findByToken(
                                request.getRefreshToken()
                        )
                );

        User user = token.getUser();

        List<String> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .toList();

        String newAccessToken =
                jwtUtil.generateToken(user.getUsername(), roles);

        return new LoginResponse(
                newAccessToken,
                token.getToken()
        );
    }

    // ---------------- LOGOUT (JWT-based) ----------------
    @PostMapping("/logout")
    public String logout() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        User user = userService.findByUsername(username);

        refreshTokenService.deleteByUser(user);

        return "Logged out successfully";
    }
}
