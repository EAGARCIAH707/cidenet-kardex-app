package com.cidenet.kardexapp.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@Profile("test")
public class PersistenceConfig {

    private String url = "jdbc:postgresql://ec2-52-7-39-178.compute-1.amazonaws.com:5432/d4q77k6rjf8s95";
    private String username = "uhvjlughtqmzhm";
    private String password = "b7f945521002ac5d6f184297446d07395914050938d96a94274820fb80f23696";
    private String driverClassName = "org.postgresql.Driver";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
