package com.cidenet.kardexapp.commons.domains.generic;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Builder
@ToString
public class InDTO {
    private Integer inId;
    private Integer quantity;
    private Timestamp lastModified;
    private Integer kardexId;
    private String observation;
    private Integer unitValue;
    private Integer totalValue;
    private Timestamp date;
}
