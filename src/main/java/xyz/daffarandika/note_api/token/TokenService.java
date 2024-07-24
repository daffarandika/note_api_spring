package xyz.daffarandika.note_api.token;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import xyz.daffarandika.note_api.auth.model.User;
import xyz.daffarandika.note_api.auth.repository.UserRepository;

import static java.time.temporal.ChronoUnit.*;

/**
 * TokenController
 */
@Service
public class TokenService {

	private final JwtEncoder jwtEncoder;
	private final JwtDecoder jwtDecoder;
	private final UserRepository userRepository;

	public TokenService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, UserRepository userRepository) {
		this.jwtEncoder = jwtEncoder;
		this.jwtDecoder = jwtDecoder;
		this.userRepository = userRepository;
	}

	public String generateToken(Authentication authentication) {
		Instant now = Instant.now();
		String scope = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
		JwtClaimsSet claims = JwtClaimsSet.builder()
				.issuer("self")
				.issuedAt(now)
				.expiresAt(now.plus(45, MINUTES))
				.subject(
						userRepository.findByUsername(authentication.getName())
								.orElseThrow()
								.getId()
								.toString()
				)
				.claim("scope", scope)
				.build();
		return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}

	public String getIdFromToken(String token) {
		Jwt jwt = jwtDecoder.decode(token);
		Map<String, Object> claims = jwt.getClaims();
		var sub = claims.get("sub");
		System.out.println("<=> SUB: " + sub.toString());
		return sub.toString();
	}
}
