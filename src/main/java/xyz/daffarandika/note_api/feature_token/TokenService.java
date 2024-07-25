package xyz.daffarandika.note_api.feature_token;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import xyz.daffarandika.note_api.feature_auth.repository.UserRepository;

import static java.time.temporal.ChronoUnit.*;

/**
 * TokenController
 */
@Service
public class TokenService {

	private final JwtEncoder jwtEncoder;
	private final UserRepository userRepository;

	public TokenService(JwtEncoder jwtEncoder, UserRepository userRepository) {
		this.jwtEncoder = jwtEncoder;
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

}
