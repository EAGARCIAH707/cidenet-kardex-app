package com.cidenet.kardexapp.commons.domains.generic;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Builder
@ToString
public class ProductDTO {

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
}
