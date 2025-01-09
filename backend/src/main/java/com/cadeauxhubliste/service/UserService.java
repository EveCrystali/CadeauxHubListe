package com.cadeauxhubliste.service;

import java.util.Date;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cadeauxhubliste.model.User;
import com.cadeauxhubliste.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String JWT_SECRET_KEY;
    @Value("${jwt.expiration}")
    private Integer JWT_EXPIRATION_TIME;

    @PostConstruct
    public void init() {
        if (JWT_SECRET_KEY == null || JWT_SECRET_KEY.trim().isEmpty()) {
            throw new IllegalStateException("JWT secret cannot be null or empty");
        }
    }

    public String loginUser(String username, String password) throws AuthenticationException {
        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new AuthenticationException("Nom d'utilisateur ou mot de passe invalide"));

            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new AuthenticationException("Nom d'utilisateur ou mot de passe invalide");
            }

            return Jwts.builder()
                    .setSubject(user.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME)) // 1 heure
                    .signWith(SignatureAlgorithm.HS256, JWT_SECRET_KEY.getBytes())
                    .compact();
        } catch (AuthenticationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'authentification", e);
        }
    }
}
