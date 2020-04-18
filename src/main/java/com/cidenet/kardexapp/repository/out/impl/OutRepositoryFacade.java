package com.cidenet.kardexapp.repository.out.impl;

import com.cidenet.kardexapp.model.entities.OutEntity;

import java.util.Optional;

public interface OutRepositoryFacade {
    Optional<OutEntity>save(OutEntity outEntity);
}
