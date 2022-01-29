package com.derifdev.restauthjwt.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;


public class JWTGenerated {
    private final Algorithm algorithm = Algorithm.HMAC256("my_auth");

    public String getToken(String email, int id) {
        String token = JWT.create()
                .withIssuer("auth0")
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .withClaim("id", id)
                .sign(algorithm);

        return token;
    }

    public String getRefreshToken(String email) {
        String refresh_token = JWT.create()
                .withIssuer("auth0")
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
//                .withIssuer()
                .sign(algorithm);

        return refresh_token;
    }
}
