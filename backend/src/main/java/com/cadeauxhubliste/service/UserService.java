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

    @Autowired
    private JwtService jwtService;

    public String loginUser(String username, String password) throws AuthenticationException {
        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new AuthenticationException("Nom d'utilisateur ou mot de passe invalide"));

            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new AuthenticationException("Nom d'utilisateur ou mot de passe invalide");
            }

            return jwtService.generateToken(convertToUserDetails(user));
        } catch (AuthenticationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'authentification", e);
        }
    }

    private org.springframework.security.core.userdetails.UserDetails convertToUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles().toArray(new String[0])) // Assure-toi que ton User a une méthode getRoles()
                .build();
    }
}
