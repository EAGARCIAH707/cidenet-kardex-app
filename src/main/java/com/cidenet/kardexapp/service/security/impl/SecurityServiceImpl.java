package com.cidenet.kardexapp.service.security.impl;

import com.cidenet.kardexapp.configuration.JwtTokenUtil;
import com.cidenet.kardexapp.service.security.ISecurityService;
import com.cidenet.kardexapp.service.userDetail.UserDetailsServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SecurityServiceImpl implements ISecurityService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;


    public SecurityServiceImpl(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public String authenticate(String email, String password) {
        log.trace("Authenticate,{},{}", email, password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        return jwtTokenUtil.generateToken(userDetails);
    }
}
