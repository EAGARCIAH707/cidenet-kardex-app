package com.cidenet.kardexapp.testdatabuilder;

import com.cidenet.kardexapp.commons.domains.generic.InDTO;

import java.sql.Timestamp;
import java.util.Date;

public class InDTOTestDataBuilder {

    private Integer inId;
    private Integer quantity;
    private Timestamp lastModified;
    private Integer kardexId;
    private String observation;
    private Double unitValue;
    private Double totalValue;
    private Timestamp date;
    private Double kUnitValue;
    private Double kTotalValue;
    private Integer kQuantity;
    private Integer type;

    public InDTOTestDataBuilder() {
        this.quantity = 45;
        this.lastModified = new Timestamp(new Date().getTime());
        this.kardexId = 2;
        this.observation = "test";
        this.date = new Timestamp(new Date().getTime());
        this.unitValue = 0.0;

    }

    public InDTO inBuilder() {
        return new InDTO(inId, quantity, lastModified, kardexId, observation, unitValue, totalValue, date, kUnitValue,
                kTotalValue, kQuantity,type);
    }
}
