package com.cidenet.kardexapp.repository.in.impl;

import com.cidenet.kardexapp.model.entities.InEntity;

import java.util.Optional;

public interface InRepositoryFacade {
    Optional<InEntity> save(InEntity inEntity);
}
