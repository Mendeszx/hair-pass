package com.api.hairpass.domain.services;

import com.api.hairpass.domain.entities.UsuarioEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private static final String SECRET_KEY = "secret_key";
    private static final Long EXPIRATION_MILLIS = 3600000L;

    public String generateToken(UsuarioEntity usuarioEntity, String emissor) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_MILLIS);

        return JWT.create()
                .withIssuer("hair-pass") // Essa reivindicação indica quem emitiu o token.
                .withSubject(usuarioEntity.getEmail()) // A reivindicação de assunto é usada para identificar o principal ou a entidade sobre a qual o token fornece informações ou autenticação
                .withIssuedAt(now)
                .withExpiresAt(expirationDate)
                .withClaim("id", usuarioEntity.getUsuarioId())
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public String getSubject(DecodedJWT token) {
        return token.getSubject();
    }

    public DecodedJWT tokenVerify(String jwt) {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build()
                .verify(jwt);
    }
}
