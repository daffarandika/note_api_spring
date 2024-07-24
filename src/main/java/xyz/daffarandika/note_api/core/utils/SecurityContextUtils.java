package xyz.daffarandika.note_api.core.utils;

import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.security.Principal;
import java.util.Map;

public class SecurityContextUtils {

    public static Integer getUserId() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal instanceof JwtAuthenticationToken jwtToken) {
            Map<String, Object> claims = jwtToken.getToken().getClaims();
            return Integer.parseInt((String) claims.get("sub"));
        } else {
            throw new CredentialsExpiredException("invalid token");
        }
    }
}

