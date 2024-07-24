package xyz.daffarandika.note_api.feature_auth.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class SignupResponse {
    private final String username;
    private final Date createdAt;

    public SignupResponse(String username, Date createdAt) {
        this.username = username;
        this.createdAt = createdAt;
    }
}
