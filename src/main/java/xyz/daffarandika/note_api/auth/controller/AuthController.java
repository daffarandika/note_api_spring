package xyz.daffarandika.note_api.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import xyz.daffarandika.note_api.auth.model.AuthResponse;
import xyz.daffarandika.note_api.auth.model.LoginRequest;
import xyz.daffarandika.note_api.auth.service.AuthService;
import xyz.daffarandika.note_api.token.TokenService;

import org.springframework.security.core.Authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AuthController
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;
    private final AuthService authService;

    public AuthController(TokenService tokenService, AuthService authService) {
        this.tokenService = tokenService;
        this.authService = authService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);
        return token;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse user = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user.getUsername().isEmpty() && user.getToken().isEmpty()) {
            throw new BadCredentialsException("Invalid username " + loginRequest.getUsername() + " or password " + loginRequest.getPassword());
        }
        return ResponseEntity.ok(user);
    }

}
