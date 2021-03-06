package com.cidenet.kardexapp.configuration;

import com.cidenet.kardexapp.commons.constants.api.EnpointApi;
import com.cidenet.kardexapp.commons.constants.api.in.IEndpointIn;
import com.cidenet.kardexapp.commons.constants.api.kardex.EndpointKardex;
import com.cidenet.kardexapp.commons.constants.api.out.IEndpointOut;
import com.cidenet.kardexapp.commons.constants.api.product.IEndpointProduct;
import com.cidenet.kardexapp.commons.constants.api.user.IEndpointUser;
import com.cidenet.kardexapp.service.userDetail.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private UserDetailsServiceImpl userDetailsService;
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public WebSecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
                             UserDetailsServiceImpl userDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(EnpointApi.BASE_PATH.concat(IEndpointUser.LOGIN)).permitAll()
                .antMatchers(HttpMethod.OPTIONS, EnpointApi.BASE_PATH.concat(EndpointKardex.FIND_ALL)).permitAll()
                .antMatchers(HttpMethod.OPTIONS, EnpointApi.BASE_PATH.concat(EndpointKardex.FIND_KARDEX_BY_ID)).permitAll()
                .antMatchers(HttpMethod.OPTIONS, EnpointApi.BASE_PATH.concat(IEndpointProduct.GET_PRODUCTS)).permitAll()
                .antMatchers(HttpMethod.OPTIONS, EnpointApi.BASE_PATH.concat(IEndpointProduct.CREATE_PRODUCT)).permitAll()
                .antMatchers(HttpMethod.OPTIONS, EnpointApi.BASE_PATH.concat(IEndpointOut.CREATE_OUT)).permitAll()
                .antMatchers(HttpMethod.OPTIONS, EnpointApi.BASE_PATH.concat(IEndpointIn.CREATE_IN)).permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
