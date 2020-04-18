package com.cidenet.kardexapp.service.out.impl;

import com.cidenet.kardexapp.commons.converter.OutConverter;
import com.cidenet.kardexapp.commons.domains.generic.OutDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.model.entities.OutEntity;
import com.cidenet.kardexapp.repository.out.impl.OutRepositoryFacade;
import com.cidenet.kardexapp.service.kardex.IKardexService;
import com.cidenet.kardexapp.service.out.IOutService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutServiceImpl implements IOutService {
    private final OutRepositoryFacade outRepository;
    private final IKardexService kardexService;
    private final OutConverter outConverter;

    public OutServiceImpl(OutRepositoryFacade outRepository, IKardexService kardexService, OutConverter outConverter) {
        this.outRepository = outRepository;
        this.kardexService = kardexService;
        this.outConverter = outConverter;
    }

    @Override
    public OutEntity createOut(OutDTO outDTO) throws SystemException, NotFoundException {
        KardexEntity kardex = kardexService.findKardexById(outDTO.getKardexId());
        Double unitCost = outDTO.getUnitValue() > 0 ? outDTO.getUnitValue() :
                (Math.round(kardex.getUnitCost() * 100.0) / 100.0);
        outDTO.setUnitValue(unitCost);
        Optional<OutEntity> out = outRepository.save(outConverter.converterOutDTOToInEntity(outDTO));
        if (out.isPresent()) {
            kardexService.updateKardexFromOut(out.get(), kardex);
            return out.get();
        } else {
            throw new SystemException("Not possible create Out");
        }
    }
}
