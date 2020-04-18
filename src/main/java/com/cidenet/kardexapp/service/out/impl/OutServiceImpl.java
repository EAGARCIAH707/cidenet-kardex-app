package com.cidenet.kardexapp.service.out.impl;

import com.cidenet.kardexapp.commons.converter.OutConverter;
import com.cidenet.kardexapp.commons.domains.generic.OutDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.OutEntity;
import com.cidenet.kardexapp.repository.out.impl.OutRepositoryFacade;
import com.cidenet.kardexapp.service.out.IOutService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutServiceImpl implements IOutService {
    private final OutRepositoryFacade outRepository;
    private final OutConverter outConverter;

    public OutServiceImpl(OutRepositoryFacade outRepository, OutConverter outConverter) {
        this.outRepository = outRepository;
        this.outConverter = outConverter;
    }

    @Override
    public OutEntity createOut(OutDTO outDTO) throws SystemException {
        Optional<OutEntity> out = outRepository.save(outConverter.converterOutDTOToInEntity(outDTO));
        if (out.isPresent()){
            return out.get();
        }else {
            throw new SystemException("Not possible create Out");
        }
    }
}
