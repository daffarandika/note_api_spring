package xyz.daffarandika.note_api.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import xyz.daffarandika.note_api.auth.model.LoginResponse;
import xyz.daffarandika.note_api.auth.model.LoginRequest;
import xyz.daffarandika.note_api.auth.model.SignupRequest;
import xyz.daffarandika.note_api.auth.model.SignupResponse;
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
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse user = authService.login(loginRequest);
            return ResponseEntity.ok(user);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        try {
            SignupResponse user = authService.signup(signupRequest);
            return ResponseEntity.ok(user);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
