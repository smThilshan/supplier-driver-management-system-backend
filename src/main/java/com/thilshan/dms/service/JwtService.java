package com.thilshan.dms.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

//    private final Key key;
//    private final long jwtExpirationMs;
//
//    public JwtService(
////            @Value("${app.jwt.secret}") String secret,
////            @Value("${app.jwt.expiration}") long jwtExpirationMs
//    ) {
//        // Ensure the secret key is at least 32 chars long for HS256
//        if (secret.length() < 32) {
//            secret = secret + "12345678901234567890123456789012";
//        }
//        this.key = Keys.hmacShaKeyFor(secret.getBytes());
//        this.jwtExpirationMs = jwtExpirationMs;
//    }
//
//    public String generateToken(String username, String role) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("role", "ROLE_"+role);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return extractAllClaims(token).getSubject();
//    }
//
//    public boolean isTokenValid(String token, String username) {
//        return username.equals(extractUsername(token)) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractAllClaims(token).getExpiration().before(new Date());
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
}