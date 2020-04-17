package com.cidenet.kardexapp.service.kardex.impl;

import com.cidenet.kardexapp.repository.kardex.impl.KardexRepositoryFacade;
import com.cidenet.kardexapp.service.kardex.IKardexService;

public class KardexServiceImpl implements IKardexService {
    private final KardexRepositoryFacade kardexRepositoryFacade;

    public KardexServiceImpl(KardexRepositoryFacade kardexRepositoryFacade) {
        this.kardexRepositoryFacade = kardexRepositoryFacade;
    }
}
