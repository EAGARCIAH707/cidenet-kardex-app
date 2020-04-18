package com.cidenet.kardexapp.commons.domains.generic;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Builder
@ToString
public class KardexDTO {

    private Integer idKardex;
    private Integer productId;
    private Integer minimumStock;
    private Integer maximumStock;
    private String reference;
    private Integer unitCost;
    private Integer totalCost;
}
