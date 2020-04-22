package com.cidenet.kardexapp.commons.converter;

import com.cidenet.kardexapp.commons.domains.generic.InDTO;
import com.cidenet.kardexapp.model.entities.InEntity;
import com.cidenet.kardexapp.model.entities.KardexEntity;
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
                .totalValue(inDTO.getTotalValue())
                .kTotalValue(inDTO.getKTotalValue())
                .kUnitValue(inDTO.getUnitValue())
                .kQuantity(inDTO.getKQuantity())
                .type(0)
                .date(inDTO.getDate() != null ? inDTO.getDate() : new Timestamp(new Date().getTime()))
                .build();
    }

    public InEntity converterKardexToIn(KardexEntity kardexEntity) {
        return InEntity.builder()
                .quantity(kardexEntity.getQuantity())
                .unitValue(kardexEntity.getUnitCost())
                .totalValue(kardexEntity.getTotalCost())
                .kUnitValue(kardexEntity.getUnitCost())
                .kTotalValue(kardexEntity.getTotalCost())
                .kQuantity(kardexEntity.getQuantity())
                .kardexId(kardexEntity.getIdKardex())
                .observation("Creacion Prod")
                .type(0)
                .date(new Timestamp(new Date().getTime()))
                .lastModified(new Timestamp(new Date().getTime()))
                .build();
    }

    public InDTO converterInEntityToInDTO(InEntity inEntity) {
        return InDTO.builder()
                .inId(inEntity.getInId())
                .quantity(inEntity.getQuantity())
                .type(inEntity.getType())
                .lastModified(inEntity.getLastModified())
                .kUnitValue(inEntity.getKUnitValue())
                .kQuantity(inEntity.getKQuantity())
                .kTotalValue(inEntity.getKTotalValue())
                .observation(inEntity.getObservation())
                .unitValue(inEntity.getUnitValue())
                .totalValue(inEntity.getTotalValue())
                .date(inEntity.getDate())
                .kardexId(inEntity.getKardexId())
                .build();
    }
}
