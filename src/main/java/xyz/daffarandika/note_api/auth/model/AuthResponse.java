package xyz.daffarandika.note_api.auth.model;

import lombok.Getter;

@Getter
public class AuthResponse {
    private String username;
    private String token;

     public AuthResponse(String username, String token) {
         this.username = username;
         this.token = token;
     }

     public AuthResponse() {
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
