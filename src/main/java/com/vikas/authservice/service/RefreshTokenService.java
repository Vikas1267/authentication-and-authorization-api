package com.vikas.authservice.service;

import com.vikas.authservice.entity.RefreshToken;
import com.vikas.authservice.entity.User;
import com.vikas.authservice.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private static final long REFRESH_TOKEN_DURATION_MS =
            7L * 24 * 60 * 60 * 1000; // 7 days

    private final RefreshTokenRepository repository;

    public RefreshTokenService(RefreshTokenRepository repository) {
        this.repository = repository;
    }

    public RefreshToken createRefreshToken(User user) {

        // one refresh token per user
        repository.findByUser(user)
                .ifPresent(repository::delete);

        RefreshToken token = new RefreshToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(
                Instant.now().plusMillis(REFRESH_TOKEN_DURATION_MS)
        );

        return repository.save(token);
    }

    public RefreshToken findByToken(String token) {
        return repository.findByToken(token)
                .orElseThrow(() ->
                        new RuntimeException("Invalid refresh token"));
    }

    // 🔥 IMPORTANT FIX: return RefreshToken
    public RefreshToken verifyExpiration(RefreshToken token) {

        if (token.getExpiryDate().isBefore(Instant.now())) {
            repository.delete(token);
            throw new RuntimeException("Refresh token expired");
        }

        return token;
    }

    public void deleteByUser(User user) {
        repository.findByUser(user)
                .ifPresent(repository::delete);
    }
}
