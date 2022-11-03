package org.example.springauth.sessionjwt.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
public class JavaJwtUtils {

    // private final static String SECRET_KEY = "whatever";
    // base64 encoded
    private final static String SECRET_KEY = "d2hhdGV2ZXIK";

    public static String generateToken(String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
//            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            Instant issueAt = Instant.now();
            Instant expiresAt = issueAt.plus(2, ChronoUnit.HOURS);
            String token = JWT.create()
                    // register claims
//                    .withIssuer("chenlong")
                    .withIssuedAt(issueAt)
                    .withExpiresAt(expiresAt)
//                    .withSubject()
//                    .withAudience()
                    // private claims
                    .withClaim("username", username)
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
        }
        return null;
    }

    public static String verify(String token) {
        if (ObjectUtils.isEmpty(token)) {
            return null;
        }
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
//                .withClaim("number-claim", 123)
//                .withClaimPresence("some-claim-that-just-needs-to-be-present")
//                .withClaim("predicate-claim", (claim, decodedJWT) -> "custom value".equals(claim.asString()))
                .build();
        try {
            DecodedJWT jwt = verifier.verify(token);
            String username = jwt.getClaim("username").asString();
            return username;
        } catch (JWTVerificationException e) {
            log.error("校验失败", e);
        }
        return null;
    }
}
