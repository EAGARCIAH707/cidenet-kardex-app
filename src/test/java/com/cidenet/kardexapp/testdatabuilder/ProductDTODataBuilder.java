package com.cidenet.kardexapp.testdatabuilder;

import com.cidenet.kardexapp.commons.domains.generic.ProductDTO;

import java.sql.Date;
import java.sql.Timestamp;

public class ProductDTODataBuilder {
    private Integer productId;
    private String name;
    private String reference;
    private Double salePrice;
    private Double purchasePrice;
    private String description;
    private Boolean state;
    private Boolean available;
    private Timestamp createdOn;
    private Timestamp lastModified;
    private Integer quantity;

    public ProductDTODataBuilder() {
        this.name = "name test";
        this.reference = "reference test";
        this.salePrice = 20000.0;
        this.purchasePrice = 30000.0;
        this.description = "description test";
        this.quantity = 10;
    }

    public ProductDTO productBuilder() {
        return new ProductDTO(productId, name, reference, salePrice, purchasePrice, description, state, available,
                createdOn, lastModified, quantity);
    }
}
