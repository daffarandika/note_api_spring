package xyz.daffarandika.note_api.feature_auth.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginRequest {

    @Valid

    @NotNull(message = "username cannot be empty")
    @NotBlank(message = "username cannot be empty")
    private final String username;

    @NotNull(message = "password cannot be empty")
    @NotBlank(message = "password cannot be empty")
    private final String password;

    LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
