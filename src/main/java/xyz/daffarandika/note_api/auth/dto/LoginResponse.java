package xyz.daffarandika.note_api.auth.dto;

import lombok.Getter;

@Getter
public class LoginResponse {
    private final String username;
    private final String token;

     public LoginResponse(String username, String token) {
         this.username = username;
         this.token = token;
     }

     public LoginResponse() {
         this.username = "";
         this.token = "";
     }

    @Override
    public String toString() {
        return "logged in user = {" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
