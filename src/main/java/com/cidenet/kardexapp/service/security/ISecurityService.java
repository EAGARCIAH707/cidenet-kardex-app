package com.cidenet.kardexapp.service.security;

public interface ISecurityService {
    String authenticate(String email, String password);
}
