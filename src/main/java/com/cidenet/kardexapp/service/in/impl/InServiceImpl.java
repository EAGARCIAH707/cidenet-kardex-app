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
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
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
    public InDTO createIn(InDTO inDTO) throws SystemException, NotFoundException {
        log.info("create in,{}", inDTO);
        KardexEntity kardex = kardexService.findKardex(inDTO.getKardexId());
        Optional<InEntity> in = inRepository.save(inConverter.converterInDTOToInEntity(calculateValues(inDTO, kardex)));
        if (in.isPresent()) {
            return inConverter.converterInEntityToInDTO(in.get());
        } else {
            log.error("Not possible create In");
            throw new SystemException("Not possible create In");
        }
    }

    public InDTO calculateValues(InDTO inDTO, KardexEntity kardex) {
        log.info("calculating values and updating kardex,{},{}", inDTO, kardex);
        Double unitCost = inDTO.getUnitValue() > 0 ? inDTO.getUnitValue()
                : (Math.round(kardex.getUnitCost() * 100.0) / 100.0);
        inDTO.setUnitValue(unitCost);
        inDTO.setTotalValue(inDTO.getQuantity() * unitCost);

        kardex.setQuantity(kardex.getQuantity() + inDTO.getQuantity());
        kardex.setTotalCost(kardex.getTotalCost() + inDTO.getTotalValue());
        kardex.setUnitCost(kardex.getTotalCost() / (kardex.getQuantity() == 0 ? 1 : kardex.getQuantity()));

        inDTO.setKQuantity(kardex.getQuantity());
        inDTO.setKTotalValue(kardex.getTotalCost());
        inDTO.setKUnitValue(kardex.getUnitCost());

        kardexService.updateKardex(kardex);
        return inDTO;
    }

    @Override
    public void createInFromKardex(KardexEntity kardexEntity) throws SystemException {
        if (kardexEntity.getQuantity() > 0) {
            save(inConverter.converterKardexToIn(kardexEntity));
        } else {
            log.error("It is not possible to create a product with a negative amount");
            throw new SystemException("It is not possible to create a product with a negative amount");
        }
    }

    @Override
    public void save(InEntity inEntity) {
        inRepository.save(inEntity);
    }
}
