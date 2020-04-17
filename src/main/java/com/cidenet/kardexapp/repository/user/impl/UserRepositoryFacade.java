package com.cidenet.kardexapp.repository.user.impl;

import com.cidenet.kardexapp.model.entities.UserEntity;

import java.util.Optional;

public interface UserRepositoryFacade {
    Optional<UserEntity> findUserByEmail(String email);
}
