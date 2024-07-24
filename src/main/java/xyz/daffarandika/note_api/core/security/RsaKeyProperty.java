package xyz.daffarandika.note_api.core.security;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * RsaKeyProperty
 */

@ConfigurationProperties(prefix = "rsa")
public record RsaKeyProperty(RSAPublicKey publicKey, RSAPrivateKey privateKey) { }
