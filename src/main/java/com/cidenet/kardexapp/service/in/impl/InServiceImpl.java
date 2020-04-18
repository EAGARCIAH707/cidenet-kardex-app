package com.cidenet.kardexapp.service.in.impl;

import com.cidenet.kardexapp.commons.converter.InConverter;
import com.cidenet.kardexapp.commons.domains.generic.InDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.InEntity;
import com.cidenet.kardexapp.repository.in.impl.InRepositoryFacade;
import com.cidenet.kardexapp.service.in.IInService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InServiceImpl implements IInService {
    private final InRepositoryFacade inRepository;
    private final InConverter inConverter;

    public InServiceImpl(InRepositoryFacade inRepository, InConverter inConverter) {
        this.inRepository = inRepository;
        this.inConverter = inConverter;
    }

    @Override
    public InEntity createIn(InDTO inDTO) throws SystemException {
        Optional<InEntity> in = inRepository.save(inConverter.converterInDTOToInEntity(inDTO));
        if (in.isPresent()) {
            return in.get();
        } else {
            throw new SystemException("Not possible create In");
        }
    }
}
