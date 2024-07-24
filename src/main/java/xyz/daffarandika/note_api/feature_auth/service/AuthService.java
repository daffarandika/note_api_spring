package xyz.daffarandika.note_api.feature_auth.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.daffarandika.note_api.feature_auth.dto.LoginRequest;
import xyz.daffarandika.note_api.feature_auth.dto.LoginResponse;
import xyz.daffarandika.note_api.feature_auth.dto.SignupRequest;
import xyz.daffarandika.note_api.feature_auth.dto.SignupResponse;
import xyz.daffarandika.note_api.feature_auth.model.*;
import xyz.daffarandika.note_api.feature_auth.repository.UserRepository;
import xyz.daffarandika.note_api.feature_token.TokenService;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            TokenService tokenService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        try {
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            String token = tokenService.generateToken(authentication);
            return new LoginResponse(username, token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("invalid username or password");
        }
    }

    public SignupResponse signup(SignupRequest signupRequest) {
        try {
            User user = new User(signupRequest);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return new SignupResponse(signupRequest.getUsername(), signupRequest.getCreatedAt());
        } catch (DataIntegrityViolationException e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }
}
