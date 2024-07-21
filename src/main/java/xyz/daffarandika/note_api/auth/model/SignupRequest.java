package xyz.daffarandika.note_api.auth.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class SignupRequest {
    private final String username;
    private final String name;
    private final String password;
    private final String email;
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
