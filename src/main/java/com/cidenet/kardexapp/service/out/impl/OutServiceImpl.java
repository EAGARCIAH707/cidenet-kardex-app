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
        Optional<OutEntity> out = outRepository.save(outConverter
                .converterOutDTOToInEntity(calculateValues(outDTO, kardex)));
        if (out.isPresent()) {
            return out.get();
        } else {
            throw new SystemException("Not possible create Out");
        }
    }

    public OutDTO calculateValues(OutDTO outDTO, KardexEntity kardex) {
        Double unitCost = outDTO.getUnitValue() > 0 ? outDTO.getUnitValue() :
                (Math.round(kardex.getUnitCost() * 100.0) / 100.0);
        outDTO.setUnitValue(unitCost);
        outDTO.setTotalValue(outDTO.getQuantity() * outDTO.getUnitValue());
        kardex.setQuantity(kardex.getQuantity() - outDTO.getQuantity());
        kardex.setTotalCost(kardex.getTotalCost() - outDTO.getTotalValue());
        kardex.setUnitCost(kardex.getTotalCost() /
                (kardex.getQuantity() == 0 ? 1 : kardex.getQuantity()));
        outDTO.setUnitValue(unitCost);
        outDTO.setKTotalValue(kardex.getTotalCost());
        outDTO.setKUnitValue(kardex.getUnitCost());
        kardexService.updateKardex(kardex);
        return outDTO;
    }
}
