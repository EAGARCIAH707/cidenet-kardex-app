package com.cidenet.kardexapp.repository.out.impl;

import com.cidenet.kardexapp.model.entities.OutEntity;
import com.cidenet.kardexapp.repository.out.IOutRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OutRepositoryImpl implements OutRepositoryFacade {
    private final IOutRepository outRepository;

    public OutRepositoryImpl(IOutRepository outRepository) {
        this.outRepository = outRepository;
    }

    @Override
    public Optional<OutEntity> save(OutEntity outEntity) {
        return Optional.of(outRepository.save(outEntity));
    }
}
