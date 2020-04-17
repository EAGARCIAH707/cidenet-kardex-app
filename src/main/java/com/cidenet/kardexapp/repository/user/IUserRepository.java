package com.cidenet.kardexapp.repository.user;

import com.cidenet.kardexapp.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findUserByEmail(String email);
}
