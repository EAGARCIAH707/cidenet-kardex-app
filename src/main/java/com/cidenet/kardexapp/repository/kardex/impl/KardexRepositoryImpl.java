package com.cidenet.kardexapp.repository.kardex.impl;

import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.repository.kardex.IKardexRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KardexRepositoryImpl implements KardexRepositoryFacade {
    private final IKardexRepository kardexRepository;

    public KardexRepositoryImpl(IKardexRepository kardexRepository) {
        this.kardexRepository = kardexRepository;
    }

    @Override
    public Optional<KardexEntity> save(KardexEntity kardexEntity) {
        return Optional.of(kardexRepository.save(kardexEntity));
    }
}
