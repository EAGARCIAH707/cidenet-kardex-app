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

    public InDTOTestDataBuilder() {
        this.quantity = 10;
        this.lastModified = new Timestamp(new Date().getTime());
        this.kardexId = 20;
        this.observation = "observation";
        this.unitValue = 25542.0;
        this.totalValue = 25542.0;
        this.date = new Timestamp(new Date().getTime());
        this.kUnitValue = 25542.0;
        this.kTotalValue = 25542.0;
    }

    public InDTO inBuilder() {
        return new InDTO(inId, quantity, lastModified, kardexId, observation, unitValue, totalValue, date, kUnitValue,
                kTotalValue);
    }
}
