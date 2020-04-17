package com.cidenet.kardexapp.repository.user.impl;

import com.cidenet.kardexapp.model.entities.UserEntity;
import com.cidenet.kardexapp.repository.user.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepositoryFacade {
    private final IUserRepository userRepository;

    public UserRepositoryImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
