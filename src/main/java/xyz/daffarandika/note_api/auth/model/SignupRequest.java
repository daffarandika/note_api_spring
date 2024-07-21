package xyz.daffarandika.note_api.auth.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.util.Date;

@Getter
public class SignupRequest {

    @Valid

    @NotNull(message = "username cannot be empty")
    @NotBlank(message = "username cannot be empty")
    private final String username;

    @NotNull(message = "name cannot be empty")
    @NotBlank(message = "name cannot be empty")
    private final String name;

    @NotNull(message = "password cannot be empty")
    @NotBlank(message = "password cannot be empty")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,}$",
            message = "password must be at least 8 characters and contain a letter and a number"
    )
    private final String password;

    @NotNull(message = "email cannot be empty")
    @NotBlank(message = "email cannot be empty")
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
