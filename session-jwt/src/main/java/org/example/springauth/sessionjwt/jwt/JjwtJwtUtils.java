package org.example.springauth.sessionjwt.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.ObjectUtils;

import java.time.Duration;
import java.util.Date;

public class JjwtJwtUtils {
    // private final static String SECRET_KEY = "whatever";
    // base64 encoded
    private final static String SECRET_KEY = "d2hhdGV2ZXIK";

    private final static Duration EXPIRATION = Duration.ofHours(2);

    public static String generate(String username) {
        Date expiryDate = new Date(System.currentTimeMillis() + EXPIRATION.toMillis());
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY)), SignatureAlgorithm.HS256)
                .compact();
    }

//    public static Claims parse(String token) {
//        if (ObjectUtils.isEmpty(token)) {
//            return null;
//        }
//        Claims claims = null;
//        try {
//            claims = Jwts.parserBuilder()
//                    .requireAudience("string")
//                    .build()
//                    .setSigningKey()
//                    .parse(token);
//        }
//    }
}
