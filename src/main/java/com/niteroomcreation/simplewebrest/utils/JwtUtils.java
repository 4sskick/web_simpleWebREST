package com.niteroomcreation.simplewebrest.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by monta on 21/12/20
 * please make sure to use credit when you're using people's code
 */

@Service
public class JwtUtils {

    @Value("$(jwt.secret)")
    private String SECRET_KEY;

    /**
     * @param claims
     * @param subject set with username from UserDetails
     * @return
     */
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                //time token is created
                .setIssuedAt(new Date((System.currentTimeMillis())))
                //set expired time of token
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 /** 60*/ * 1)) //1 minutes
                //encoding SECRET_KEY with algorithm
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    public String generateToken(UserDetails userDetails) {

        //this could be fill with payload data
        Map<String, Object> claims = new HashMap<>();

        return createToken(claims, userDetails.getUsername());
    }

    //see:
    // Function<R,T> https://www.tutorialspoint.com/how-to-implement-function-t-r-interface-with-lambda-expression-in-java
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
}
