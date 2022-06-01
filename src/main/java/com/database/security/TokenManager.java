package com.database.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 * This class is implementing JSON Web Tokens. Thanks to the JWTS information can send more securely.
 */
@Service
public class TokenManager {

    private static final int validity =7 * 24 * 60 * 60 * 1000; // expiration time of generated token.
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //


    /**
     * Create token with specified key and with determined expiration time.
     * @param username username of the player
     * @return token
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(key)
                .compact();
    }


    /**
     * Check whether the token is  not null and not expired
     * @param token user token
     * @return
     */
    public boolean tokenValidate(String token) {
        if (getUsernameToken(token) != null && isExpired(token)) {
            return true;
        }
        return false;
    }

    public String getUsernameToken(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    /**
     * Check whether the token is expired or not
     * @param token  token of the user
     * @return  whether login time is expired or not
     */
    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }
}
