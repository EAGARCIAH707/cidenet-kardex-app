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
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
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
    public OutDTO createOut(OutDTO outDTO) throws SystemException, NotFoundException {
        KardexEntity kardex = kardexService.findKardex(outDTO.getKardexId());
        if (kardex.getQuantity() < outDTO.getQuantity()) {
            log.error("The value for the output is higher than the stock,{}", kardex.getQuantity());
            throw new SystemException("The value for the output is higher than the stock");
        }
        Optional<OutEntity> out = outRepository.save(outConverter
                .converterOutDTOToInEntity(calculateValues(outDTO, kardex)));
        if (out.isPresent()) {
            return outConverter.converterOutEntityToOutDTO(out.get());
        } else {
            log.error("Not possible create Out");
            throw new SystemException("Not possible create Out");
        }
    }

    public OutDTO calculateValues(OutDTO outDTO, KardexEntity kardex) {
        log.info("calculating values and updating kardex,{},{}", outDTO, kardex);
        Double unitCost = outDTO.getUnitValue() > 0 ? outDTO.getUnitValue() :
                (Math.round(kardex.getUnitCost() * 100.0) / 100.0);
        outDTO.setUnitValue(unitCost);
        outDTO.setTotalValue(outDTO.getQuantity() * unitCost);

        kardex.setQuantity(kardex.getQuantity() - outDTO.getQuantity());
        kardex.setTotalCost(kardex.getTotalCost() - outDTO.getTotalValue());
        kardex.setUnitCost(kardex.getTotalCost() /
                (kardex.getQuantity() == 0 ? 1 : kardex.getQuantity()));

        outDTO.setKQuantity(kardex.getQuantity());
        outDTO.setKTotalValue(kardex.getTotalCost());
        outDTO.setKUnitValue(kardex.getUnitCost());
        kardexService.updateKardex(kardex);
        return outDTO;
    }
}
