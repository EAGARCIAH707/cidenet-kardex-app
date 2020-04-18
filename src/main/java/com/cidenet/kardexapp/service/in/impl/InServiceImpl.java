package com.cidenet.kardexapp.service.in.impl;

import com.cidenet.kardexapp.commons.converter.InConverter;
import com.cidenet.kardexapp.commons.domains.generic.InDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.InEntity;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.repository.in.impl.InRepositoryFacade;
import com.cidenet.kardexapp.service.in.IInService;
import com.cidenet.kardexapp.service.kardex.IKardexService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InServiceImpl implements IInService {
    private final InRepositoryFacade inRepository;
    private final IKardexService kardexService;
    private final InConverter inConverter;

    public InServiceImpl(InRepositoryFacade inRepository, IKardexService kardexService, InConverter inConverter) {
        this.inRepository = inRepository;
        this.kardexService = kardexService;
        this.inConverter = inConverter;
    }

    @Override
    public InEntity createIn(InDTO inDTO) throws SystemException, NotFoundException {
        KardexEntity kardex = kardexService.findKardexById(inDTO.getKardexId());
        Double unitCost = inDTO.getUnitValue() > 0 ? inDTO.getUnitValue() :
                (Math.round(kardex.getUnitCost() * 100.0) / 100.0);
        inDTO.setUnitValue(unitCost);
        Optional<InEntity> in = inRepository.save(inConverter.converterInDTOToInEntity(inDTO));
        if (in.isPresent()) {
            kardexService.updateKardexFromIn(in.get(), kardex);
            return in.get();
        } else {
            throw new SystemException("Not possible create In");
        }
    }
}
