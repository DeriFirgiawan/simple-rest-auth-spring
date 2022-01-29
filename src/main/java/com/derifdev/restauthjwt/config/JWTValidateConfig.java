package com.derifdev.restauthjwt.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTValidateConfig {
    private final Algorithm algorithm = Algorithm.HMAC256("my_auth");

    private DecodedJWT jwtVerifier(String token) {
         JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        DecodedJWT jwt = verifier.verify(token);
         return jwt;
    }
    public Boolean validate(String token) {
        return jwtVerifier(token).getId() != null;
    }

    public String getUsername(String token) {
        return jwtVerifier(token).getSubject();
    }
}
