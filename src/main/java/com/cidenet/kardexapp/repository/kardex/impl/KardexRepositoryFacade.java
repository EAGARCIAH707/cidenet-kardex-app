package com.cidenet.kardexapp.repository.kardex.impl;

import com.cidenet.kardexapp.model.entities.KardexEntity;

import java.util.Optional;

public interface KardexRepositoryFacade {
    Optional<KardexEntity> save(KardexEntity kardexEntity);

    Optional<KardexEntity> findById(Integer kardexId);
}
