package com.cidenet.kardexapp.commons.domains.generic;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

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
    private Integer salePrice;
    private Integer purchasePrice;
    private String description;
    private Boolean state;
    private Boolean available;
    private Date createdOn;
    private Date lastModified;
    private Integer quantity;
}
