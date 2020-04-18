package com.cidenet.kardexapp.repository.in.impl;

import com.cidenet.kardexapp.model.entities.InEntity;
import com.cidenet.kardexapp.repository.in.IInRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InRepositoryImpl implements InRepositoryFacade {
    private final IInRepository inRepository;

    public InRepositoryImpl(IInRepository inRepository) {
        this.inRepository = inRepository;
    }

    @Override
    public Optional<InEntity> save(InEntity inEntity) {
        return Optional.of(inRepository.save(inEntity));
    }
}
