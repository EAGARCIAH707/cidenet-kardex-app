package com.cidenet.kardexapp.commons.converter;

import com.cidenet.kardexapp.commons.domains.generic.OutDTO;
import com.cidenet.kardexapp.model.entities.OutEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@Log4j2
public class OutConverter {
    public OutEntity converterOutDTOToInEntity(OutDTO outDTO) {
        return OutEntity.builder()
                .quantity(outDTO.getQuantity())
                .lastModified(new Timestamp(new Date().getTime()))
                .kardexId(outDTO.getKardexId())
                .observation(outDTO.getObservation())
                .unitValue(outDTO.getUnitValue())
                .totalValue(outDTO.getTotalValue())
                .kTotalValue(outDTO.getKTotalValue())
                .kUnitValue(outDTO.getKUnitValue())
                .kQuantity(outDTO.getKQuantity())
                .date(outDTO.getDate() != null ? outDTO.getDate() : new Timestamp(new Date().getTime()))
                .type(1)
                .build();
    }
}
