package xyz.daffarandika.note_api.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.daffarandika.note_api.auth.model.AuthResponse;
import xyz.daffarandika.note_api.auth.model.User;
import xyz.daffarandika.note_api.auth.repository.UserRepository;
import xyz.daffarandika.note_api.token.TokenService;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public AuthResponse login(String username, String password) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, (password))
            );
            String token = tokenService.generateToken(authentication);
            return new AuthResponse(username, token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username " + username + " or password " + (password));
        }
    }
}
