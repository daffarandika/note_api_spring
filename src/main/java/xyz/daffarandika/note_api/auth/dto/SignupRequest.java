package xyz.daffarandika.note_api.auth.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import xyz.daffarandika.note_api.validation.Password;
import xyz.daffarandika.note_api.validation.UniqueEmail;
import xyz.daffarandika.note_api.validation.UniqueUsername;

import java.util.Date;

@Getter
public class SignupRequest {

    @Valid

    @NotNull(message = "username cannot be empty")
    @NotBlank(message = "username cannot be empty")
    @UniqueUsername
    private final String username;

    @NotNull(message = "name cannot be empty")
    @NotBlank(message = "name cannot be empty")
    private final String name;

    @NotNull(message = "password cannot be empty")
    @NotBlank(message = "password cannot be empty")
    @Password
    private final String password;

    @NotNull(message = "email cannot be empty")
    @NotBlank(message = "email cannot be empty")
    @Email(message = "invalid email")
    @UniqueEmail
    private final String email;

    @NotNull(message = "roles cannot be empty")
    @NotBlank(message = "roles cannot be empty")
    private final String roles;

    private final Date createdAt;

    public SignupRequest(String username, String name, String password, String email, String roles) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.createdAt = new Date();
    }

    public SignupRequest() {
        this.username = "";
        this.name = "";
        this.password = "";
        this.email = "";
        this.roles = "";
        this.createdAt = new Date();
    }
}
