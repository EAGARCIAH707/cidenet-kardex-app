package com.cidenet.kardexapp.auth.test;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class AuthTest {

    public static String createToken() {
        String jwt = Jwts.builder()
                .setSubject("usertest")
                .setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 60))
                .signWith(SignatureAlgorithm.HS512, "javacidenet")
                .compact();
        return jwt;
    }
}
