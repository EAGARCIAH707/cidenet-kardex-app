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
                .kardexId(kardexEntity.getIdKardex())
                .observation("Producto creado")
                .type(0)
                .date(new Timestamp(new Date().getTime()))
                .lastModified(new Timestamp(new Date().getTime()))
                .build();
    }
}
