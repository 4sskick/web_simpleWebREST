package com.niteroomcreation.simplewebrest.utils.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niteroomcreation.simplewebrest.models.data.domains.User;
import com.niteroomcreation.simplewebrest.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by monta on 22/12/20
 * please make sure to use credit when you're using people's code
 */
public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request
            , HttpServletResponse response
    ) throws AuthenticationException {

        try {
            //converting request which in JSON format to map on User.class
            User u = new ObjectMapper().readValue(request.getInputStream(), User.class);

            return manager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            u.getUserName()
                            , u.getPassword()
                            , new ArrayList<>()
                    )
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request
            , HttpServletResponse response
            , FilterChain chain
            , Authentication authResult
    ) throws IOException
            , ServletException {

//        String token = jwtUtils.generateToken()
    }
}
