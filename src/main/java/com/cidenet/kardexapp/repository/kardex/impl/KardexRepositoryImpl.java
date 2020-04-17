package com.cidenet.kardexapp.repository.kardex.impl;

import com.cidenet.kardexapp.repository.kardex.IKardexRepository;
import org.springframework.stereotype.Component;

@Component
public class KardexRepositoryImpl implements KardexRepositoryFacade {
    private final IKardexRepository kardexRepository;

    public KardexRepositoryImpl(IKardexRepository kardexRepository) {
        this.kardexRepository = kardexRepository;
    }
}
