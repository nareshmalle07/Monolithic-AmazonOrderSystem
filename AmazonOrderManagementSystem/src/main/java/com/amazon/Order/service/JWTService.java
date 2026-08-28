//package com.amazon.Order.service;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.nio.charset.StandardCharsets;
//
//@Service
//public class JWTService {
//
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    private SecretKey getSigningKey() {
//        return Keys.hmacShaKeyFor(
//                jwtSecret.getBytes(StandardCharsets.UTF_8)
//        );
//    }
//
//    public Claims extractClaims(String token) {
//
//        return Jwts.parser()
//                .verifyWith(getSigningKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    public String extractUsername(String token) {
//
//        return extractClaims(token)
//                .getSubject();
//    }
//
//    public String extractRole(String token) {
//
//        return extractClaims(token)
//                .get("role", String.class);
//    }
//
//    public boolean validateToken(String token) {
//
//        try {
//
//            extractClaims(token);
//
//            return true;
//
//        } catch (Exception exception) {
//
//            return false;
//        }
//    }
//
//}
