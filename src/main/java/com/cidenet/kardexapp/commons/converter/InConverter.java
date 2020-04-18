package com.cidenet.kardexapp.commons.converter;

import com.cidenet.kardexapp.commons.domains.generic.InDTO;
import com.cidenet.kardexapp.model.entities.InEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@Log4j2
public class InConverter {
    public InEntity converterInDTOToInEntity(InDTO inDTO) {
        return InEntity.builder()
                .quantity(inDTO.getQuantity())
                .lastModified(new Timestamp(new Date().getTime()))
                .kardexId(inDTO.getKardexId())
                .observation(inDTO.getObservation())
                .unitValue(inDTO.getUnitValue())
                .totalValue(inDTO.getQuantity() * inDTO.getUnitValue())
                .date(inDTO.getDate())
                .build();
    }
}
