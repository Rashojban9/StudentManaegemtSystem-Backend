package com.rashoj.StudentManagementSystemTeacher.jwtConfig;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component

public class JwtUtil {
    private final String SECRET_KEY = "my_super_secret_key_that_is_very_long_1234567890";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private final long EXPIRATION_TIME = 86_400_000;

    public String generateToken(String userName) {
        return Jwts.builder().setSubject(userName).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(key).compact();

    }

    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
