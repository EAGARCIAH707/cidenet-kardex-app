package com.cidenet.kardexapp.commons.domains.generic;

import com.cidenet.kardexapp.model.entities.InEntity;
import com.cidenet.kardexapp.model.entities.OutEntity;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Builder
@ToString
public class KardexDTO {

    private Integer idKardex;
    private Integer quantity;
    private Integer minimumStock;
    private Integer maximumStock;
    private String reference;
    private Double unitCost;
    private Double totalCost;
    private ProductEntity productId;
    private List<OutEntity> outList;
    private List<InEntity> inList;
}
